# Android Project 3 - *Flixster Plus*

Submitted by: **Andrew Liu**

**Flixster Plus** is a movie browsing app that allows users to browse movies currently playing in theaters.

Time spent: **9** hours spent in total

## Required Features

The following **required** functionality is completed:

- [X] **Make a request to [The Movie Database API's `now_playing`](https://developers.themoviedb.org/3/movies/get-now-playing) endpoint to get a list of current movies**
- [X] **Parse through JSON data and implement a RecyclerView to display all movies**
- [X] **Use Glide to load and display movie poster images**

The following **optional** features are implemented:

- [ ] Improve and customize the user interface through styling and coloring
- [X] Implement orientation responsivity
  - App should neatly arrange data in both landscape and portrait mode
- [X] Implement Glide to display placeholder graphics during loading
  - Note: this feature is difficult to capture in a GIF without throttling internet speeds.  Instead, include an additional screencap of your Glide code implementing the feature.  (<10 lines of code)
  
  <img src='https://i.imgur.com/nnrNHW8.png' title='Glide Placeholder Snippet' width='500dp' alt='Glide Placeholder Snippet' />


The following **additional** features are implemented:

- [X] Rounded images for better image view

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='https://media.giphy.com/media/r0Gap4c8RleZkkwqea/giphy.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with LiceCap
<!-- Recommended tools: -->
[LiceCap](https://www.cockos.com/licecap/) for Windows

## Notes

The only difficult part with this was dealing with the JSON parsing. The response was retreived as a JSONArray which was different from the JSONObject in class, so I had to modify the JSON retrieval code a bit. In addition, the main difficult parts were just determining the layout and text of the XML files, along with aligning text and making it the way I wanted.

## License
    Copyright 2022 Andrew Liu

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
