<!-- (This is a comment) INSTRUCTIONS: Go through this page and fill out any **bolded** entries with their correct values.-->

# AND101 Project 5 - Choose Your Own API

Submitted by: Jose Huertero

Time spent: 8 hours spent in total

## Summary

Marvel Project 5 API is an android app that displays an image, character name and character description once the user inputs the name of the super hero they are looking for.

If I had to describe this project in three (3) emojis, they would be:⌚🦹‍♀️📱

## Application Features

<!-- (This is a comment) Please be sure to change the [ ] to [x] for any features you completed.  If a feature is not checked [x], you might miss the points for that item! -->

The following REQUIRED features are completed:

- [x] Make an API call to an API of your choice using AsyncHTTPClient
- [x] Display at least three (3) pieces of data for each API entry retrieved
- [x] A working Button requests a new API entry and updates the data displayed

The following STRETCH features are implemented:

- [x] Add a query to the API request
- [x] Build a UI to allow users to add that query


## API Choice

My chosen API for this project is Marvel API.

## Video Demo

Here's a video / GIF that demos all of the app's implemented features:

<img src='https://imgur.com/otBGDmV.gif' title='Video Demo' width='' alt='Video Demo' />

GIF created with [ScreenToGif](https://www.screentogif.com/) for Windows


## Notes
This app was quite challenging to complete using the Marvel API, there were a lot of issues with going through the Json file and pulling out the right data from it by navigating through the different keys.
I also came across an issue with the Glide feature because the Http was not secured then it was giving me and issue and it took me a white to debug it and find out that security was in fact the issue. I managed to solve 
this problem by simply changing the URL of every image to Https using the .replace("http://", "https://") fuction. I added a EditeText box where the user could input the type of super hero that wants to request from the API, 
this name which it would be a key then will request the path which is the picture, description, and name of the super hero input by the user.


## License

Copyright 2023 Jose Huertero

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
