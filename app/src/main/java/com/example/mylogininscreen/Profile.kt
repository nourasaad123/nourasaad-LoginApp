package com.example.mylogininscreen

     data class Profile(val name: String, val job: String)

     fun getDummyProfiles(): List<Profile> {
         return listOf(
             Profile("John", "Software Engineer"),
             Profile("Alice", "Designer"),
             Profile("Bob", "Data Scientist"),
             Profile("Emily", "Product Manager"),
             Profile("Michael", "Marketing Specialist"),
             Profile("Olivia", "Teacher"),
             Profile("David", "Doctor"),
             Profile("Sophia", "Accountant"),
             Profile("Daniel", "Sales Manager"),
             Profile("Emma", "HR Manager"),
             Profile("William", "Graphic Designer"),
             Profile("Ava", "Lawyer"),
             Profile("James", "Chef"),
             Profile("Isabella", "Architect"),
             Profile("Alexander", "Financial Analyst"),
             Profile("Mia", "Journalist"),
             Profile("Ethan", "Mechanical Engineer"),
             Profile("Charlotte", "Nurse"),
             Profile("Oliver", "Photographer"),
             Profile("Amelia", "Researcher")
         )
     }


 }