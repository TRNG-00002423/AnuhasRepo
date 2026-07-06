import java.util.Objects;

public class Student {
    
    private static int nextId;

    private int id;
    private String name;
    private String program;

    


    public Student() {
        nextId++;
    }


    public Student(int id, String name, String program) {
        this.id = id;
        this.name = name;
        this.program = program;
        nextId++;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getProgram() {
        return program;
    }


    public void setProgram(String program) {
        this.program = program;
    }

    public static int getNextId() {
        return nextId;
    }


    public static void setNextId(int nextId) {
        Student.nextId = nextId;
    }


    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", program=" + program + "]";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.id;
        hash = 41 * hash + Objects.hashCode(this.name);
        hash = 41 * hash + Objects.hashCode(this.program);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.program, other.program);
    }






}
