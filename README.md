# Android Project 6 - FitBit_Part2

Submitted by: Rickey Prewitt

FitBit_Part2 is a health metrics app that allows users to track the drink consumption of the user.
The type of drink and the number of cups consumed is recorded in the database and displayed in a list.
The user can also use the navigation bar to go to the dashboard to see the average, minimum, and maximum number of drinks they've consumed (in cups).
The database stores all data for when the user leaves, and displays the list again when the user returns.

Time spent: 5 hours spent in total

## Required Features

The following **required** functionality is completed:

- [x] **Use at least 2 Fragments**
- [x] **Create a new dashboard fragment where users can see a summary of their entered data**
- [x] **Use one of the Navigation UI Views (BottomNavigation, Drawer Layout, Top Bar) to move between the fragments**

The following **optional** features are implemented:

- [ ] **Add a more advanced UI (e.g: Graphing) for tracking trends in metrics**
- [ ] **Implement daily notifications to prompt users to fill in their data**

The following **additional** features are implemented:

- [x]  An error message will be displayed if both the name and cup fields are not filled in.

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src="https://i.ibb.co/G0KTYqR/Fit-Bit-Test-Part2.gif" alt="Fit-Bit-Test-Part2" border="0">

GIF created with ...  
[ScreenToGif](https://www.screentogif.com/) for Windows


## Notes

The hardest part for me was figuring out why the navigation bar wouldn't work. I soon found out that I wasn't supposed to use the setOnClickListener feature to call the navigation buttons.
I had to use setOnItemSelectedListener feature.

## License

    Copyright [2023] [Codepath]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
