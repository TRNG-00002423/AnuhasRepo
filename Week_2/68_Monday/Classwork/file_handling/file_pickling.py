import pickle

file=open("num_pickles.dat", "wb")

numbers=[10,20,30,40,50]

pickle.dump(numbers,file)

file.close()

file=open("num_pickles.dat", "wb")
data=pickle.load(file)
print(data)
file.close()

