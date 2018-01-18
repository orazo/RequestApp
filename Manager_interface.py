import firebase_admin
from firebase_admin import credentials
from firebase_admin import db
from firebase_admin import auth

def usersDisplay():
    ref = db.reference('Students')
    print(ref.get())

def userDelete(uid):
    auth.delete_user(uid)
    ref = db.reference('Students')
    ref.child(uid).delete()
    print("Sucessfully deleted the user " + uid)

def userCreate(firstName,lastName,email,phoneNumber,password,city,street):
    user = auth.create_user(email=email,email_verified=False,phone_number=phoneNumber,password=password,display_name=firstName+" "+lastName,disabled=False)
    ref = db.reference('Students').child(user.uid)
    ref.set({'city': city, 'First Name': firstName, 'Last Name': lastName, 'Phone Number': phoneNumber, 'Street': street})
    print('Sucessfully created new user: {0}'.format(user.uid))

cred = credentials.Certificate("C:\\Users\\Tomer\\PycharmProjects\\Mivne\\myproject-4b27b-firebase-adminsdk-32fgc-496396a069.json")
default_app = firebase_admin.initialize_app(cred, {'databaseURL': 'https://myproject-4b27b.firebaseio.com','databaseAuthVariableOverride':{'uid': 'manager'}})

while(True):
    option = input("Choose: 1-Display user  2-Delete user  3-Create user | or \"end\" to exit: ")
    if(option=="1"):
        print("You choose " + option)
        usersDisplay()

    elif(option=="2"):
        print("You choose " + option)
        uid_num = input("Enter udi to delete: ")
        userDelete(uid_num)

    elif(option=="3"):
        print("You choose " + option)
        firstName = input("Enter first name:")
        lastName = input("Enter last name:")
        email = input("Enter first email:")
        phoneNumber = input("Enter first phone number:")
        password = input("Enter first password:")
        city = input("Enter City:")
        street = input("Enter street:")
        userCreate(firstName, lastName, email, phoneNumber, password, city, street)

    elif(option=="end"):
        break

    else:
        print("Bad input!")