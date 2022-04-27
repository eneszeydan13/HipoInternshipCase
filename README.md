# HipoInternshipCase
An app to fetch data from a .json file and show it in the UI using RecyclerView. It also has options to add a new member and search among members by name. It uses the MVVM Architecture.
Made by Enes Zeydan.

I have 3 models used in the app, "HipoResponse.kt", "Hipo" and "Members".

HipoResponse class represents the data in the .json file. The file will give us a single object of this class. It has three properties called "company", "team" and 
"members". members property is basically an ArrayList of objects of Members class.

Members class represents the people in the data. It has five properties called "name", "age", "location", "github" and "hipo". hipo property is an object of the class
Hipo, which is another class in my models.

Hipo class represents the information of members related to the company. It has two basic properties called "position" and "years_in_hipo".

To get the users from "hipo.json" file, I used bufferedReader() to read the file, turned it into a String and then using Gson()'s fromJson method, I put the data into the
previously created response object. This response object is an instance of HipoResponse class. For listing the members I used RecyclerView. I have an adapter called MembersAdapter. It requires context(for LayoutInflator) and a list of Members.

I used MVVM Architecture in this application. The app has only one page therefore I created one ViewModel. HomepageFragmentViewModel contains all the functions in the app.
Also I used LiveData so when there's a change in the data, we can observe it in the UI easily. This has helped significantly in adding a new member.

For Search I used SearchView, it provides us two functions named "onQueryTextSubmit" and "onQueryTextChange". For both of these functions I changed the adapter, 
specifically the list of members sent to the adapter. To get better results, I used lowerCase() method as well as contains() method to filter the desired result.

![search](https://user-images.githubusercontent.com/69349567/165496325-169a8043-1ac5-4438-b5c3-cb884f312920.gif)

For adding a new member, when the button is pressed I created an instance of the Members class with my information, and then added this object to the Livedata manually. So it can be seen in the UI
immediately. 

![add_new](https://user-images.githubusercontent.com/69349567/165496318-c449fd51-eaf4-4581-8cef-469c166be033.gif)

