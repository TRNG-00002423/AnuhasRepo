"""
Week 2  — Flask API Mini-Project

"""

from __future__ import annotations

from pathlib import Path

from flask import Flask, jsonify, request, make_response

app = Flask(__name__)
DATA_FILE = Path(__file__).resolve().parent / "data" / "findings.json"


print("\n\n")

students = {
    0: {"id":1,"name":"Alice","course":"Computer Science"},
    1: {"id":2,"name":"Bob","course":"Calculus I"},
    2: {"id":3,"name":"Don","course":"data Science"},
    3: {"id":4,"name":"Joe","course":"iOS App Development"},
    4: {"id":5,"name":"Mo","course":"Linear Algebra"},
    5: {"id":6,"name":"Jane","course":"Numeriacal Analysis"},
}



# Display All Students
# @app.route("/students", methods=["GET"])
@app.get("/students")
def get_all_students():
    return jsonify(students)

# Display A Single Student
# @app.route("/students/<int:student_id>", methods=["GET"])
@app.get("/students/<int:student_id>")
def get_student_from_id(student_id):
    if student_id not in students:
        return make_response(jsonify({"message": f"student with id {student_id} not found"}), 404)
    student = students[student_id]
    return jsonify(student)


# Add A New Student
# @app.route("/students", methods=["POST"])
@app.post("/students/add")
def add_student():
    data=request.json
    if "id" not in data or "name" not in data or "course" not in data:
        return make_response(jsonify({"message" : "Bad Request"}, 400))
    id=int(data["id"])
    name=data["name"]
    course=data["course"]

    new_student = {
        "id" : id,
        "name" : name,
        "course" : course
    }
    students[id]=new_student
    # students.append(new_student)
    return make_response(jsonify(new_student), 201)


# Update A Student's Information
# @app.route("/students/<int:student_id>", methods=["PUT"])
@app.put("/students/update/<int:student_id>")
def update_student(student_id):
    
    #     try:
    #     data = request.json()
    #     student = get_student_from_id(student_id)[0]
    #     student["name"]=data["name"]
    #     student["course"]=data["course"]
    #     return jsonify(student), 200
    # except IndexError:
    #     return f"ERROR: STUDENT NOT FOUND. ID '{student_id} DOES NOT EXIST.", 404

    data=request.json

    if "name" not in data and "course" not in data:
        return make_response(jsonify({"message" : "Bad Request"}, 400))
    
    
    if student_id not in students:
        return make_response(jsonify({"message": f"student with id {student_id} not found"}), 404)
    
    
    name=data["name"]
    course=data["course"]
    students[id]["name"]=name
    students[id]["course"]=course
    return make_response(jsonify(students[id]))

    

# Delete A Student
# @app.route("/students/<int:student_id>", methods=["DELETE"])
@app.delete("/students/delete/<int:student_id>")
def delete_student(student_id):

    
    if student_id in students:
        return make_response(jsonify(students.pop(student_id)))
    return make_response(jsonify({"message": f"student with id {student_id} not found"}), 404)

    # try:
    #     student = get_student_from_id(student_id)[0]
    #     students.remove(student)
    #     return f"Student : {student["name"]} with ID : {student["id"]} has been deleted.", 200
    # except IndexError:
    #     return f"ERROR : ID {student_id} DOES NOT EXIST.", 404




if __name__ == "__main__":
    app.run(debug=True)
