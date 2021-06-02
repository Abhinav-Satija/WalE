# WalE

This project is created using MVVM architecture and kotlin as base programming language.
On the launcher screen which is MainActivity the api is triggered once the view model is initialized.

There are two cases, Online case and Offline case
//In online case
     if network is available then api will be triggered.
          Api response Data is then parsed and saved into db.
          Also the view would be updated with adopData  which is observed with live data.

//In offline case
 If no network is available then, we will see if there is any data from previous API available in DB.
         If its available then update the UI with adopData . else show error message



Improvements

#1 We can create better UI
#2 Api can be encrypted


Thank you.
