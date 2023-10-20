<!-- (This is a comment) INSTRUCTIONS: Go through this page and fill out any **bolded** entries with their correct values.-->

# AND101 Project 6 - CYOAPI Part 2: RecyclerView Edition

Submitted by: Jose Huertero

Time spent 9 hours spent in total

## Summary

Marvel scrollable API is an android app that allows the user to scroll and look at the different collection of Marvel characters, these are listed in alphabetical order and contain 
the image, name and description of the character.

If I had to describe this project in three (3) emojis, they would be: 🕘 🎭🖥

## Application Features

<!-- (This is a comment) Please be sure to change the [ ] to [x] for any features you completed.  If a feature is not checked [x], you might miss the points for that item! -->

The following REQUIRED features are completed:

- [x] Make an API call to an API of your choice using AsyncHTTPClient
- [x] Implement a RecyclerView to display a list of entries from the API
- [x] Display at least three (3) pieces of data for each RecyclerView item

The following STRETCH features are implemented:

- [ ] Add a UI element for the user to interact with API further
- [x] Show a `Toast` or `Snackbar` when an item is clicked
- [x] Add item dividers with `DividerItemDecoration`

The following EXTRA features are implemented:

- [x] when pulling out the description from the API, some of them would be an empty string
      and this did not look good since it was an empty box, so I changed it to "No description for this character".
- [x] made my own Divider using a drawable 
 



## Video Demo

Here's a video / GIF that demos all of the app's implemented features:

<img src='https://imgur.com/9LWUBaM.gif' title='Video Demo' width='' alt='Video Demo' />

GIF created with [ScreenToGif](https://www.screentogif.com/) for Windows

## Notes

For this project I had a few issues that took me quite a while to resolve, the first one being that I did not know how to add the other elements into the RecyclerView I was able to 
set up the images just by following the lab but the other two elements were not so simple. I figure that it was best if I made a class of characters and with the atributes image, name and description 
and then instead of passing to the Adapter a list of images I would pass a list of heroes that contained images, names and descriptions which made retrieving the data to the Adapter/onBindViewHolder much easier.
I also added an exception for some characters that did not have a description, so something would be desplayed and not just be an empty box. The last issue I had was the the API randomly stopped working and I have no Idea why and 
I have no Idea how I fixed it but the night before it was working fine and the next day it would not connectb to the API, I think it might've been something with the limit of characters I could retrieve from the API.


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
