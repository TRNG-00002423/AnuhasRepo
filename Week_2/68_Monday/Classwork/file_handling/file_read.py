file=open("data.txt", "r")


# Read Entire File
content=file.read()
print(content)


# Read One Line
line=file.readline()
print(line)

# Read All Lines
line=file.readline()
print(line)

file.close()