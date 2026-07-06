import pickle

numbers=[1,2,3,4,5,6,7]

with open("num_pick.dat", "wb") as file:
    pickle.dump(numbers, file)
    # Don't Need To Close !

with open("num_pick.dat", "rb") as file:
    data=pickle.load(file)
    # Don't Need To Close As We're Using The Context Manager, With Statement