# Project 2 - *SimpleTweet*

##*SimpleTweet Part 2*

**SimpleTweet** is an android app that allows a user to view his Twitter timeline and post a new tweet. The app utilizes [Twitter REST API](https://dev.twitter.com/rest/public).

Time spent: **15** hours spent in total

## User Stories

The following **required** functionality is completed:

- [x] User can **compose and post a new tweet**
  - [x] User can click a “Compose” icon in the Action Bar on the top right
  - [x] User can then enter a new tweet and post this to twitter
  - [x] User is taken back to home timeline with **new tweet visible** in timeline
  - [x] Newly created tweet should be manually inserted into the timeline and not rely on a full refresh
  - [x] User can **see a counter with total number of characters left for tweet** on compose tweet page

The following **optional** features are implemented:

- [x] User is using **"Twitter branded" colors and styles**
- [x] User can click links in tweets launch the web browser 
- [ ] User can **select "reply" from detail view to respond to a tweet**
- [x] The "Compose" action is moved to a FloatingActionButton instead of on the AppBar
- [ ] Compose tweet functionality is build using modal overlay
- [x] Use Parcelable instead of Serializable using the popular [Parceler library](http://guides.codepath.org/android/Using-Parceler).
- [x] User can **open the twitter app offline and see last loaded tweets**. Persisted in SQLite tweets are refreshed on every application launch. While "live data" is displayed when app can get it from Twitter API, it is also saved for use in offline mode.
- [ ] When a user leaves the compose view without publishing and there is existing text, prompt to save or delete the draft. If saved, the draft should then be **persisted to disk** and can later be resumed from the compose view.
- [ ] Enable your app to receive implicit intents from other apps. When a link is shared from a web browser, it should pre-fill the text and title of the web page when composing a tweet. 

The following **additional** features are implemented:

- [ ] List anything else that you can get done to improve the app functionality!

## Video Walkthrough

Here's a walkthrough of implemented user stories:<br>

The compose feature:<br>
<img src='https://github.com/kallytang/SimpleTweet/blob/master/compose.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' /><br>

handling too long of text message: <br>
<img src='https://github.com/kallytang/SimpleTweet/blob/master/too_long_length_tweet.gif' width='' alt='Video Walkthrough' /><br>

handling too short: <br>
<img src='https://github.com/kallytang/SimpleTweet/blob/master/too_short_length_tweet.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' /><br>

offline view, saving tweets to sql lite with a short number of saved items: <br>
<img src='https://github.com/kallytang/SimpleTweet/blob/master/offline_view_shorted_num.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' /><br>

offline view, with more data saved to sql lite: <br>
<img src='https://github.com/kallytang/SimpleTweet/blob/master/offline_view.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' /><br>


GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Notes

I added more details into the app to make it more Twitter branded, adding numbers next to the favorite and retweet button, as well as coloring the retweet to green and favorite icon to red.

##Project 2 - *SimpleTweet Part 1*

**SimpleTweet** is an android app that allows a user to view his Twitter timeline. The app utilizes [Twitter REST API](https://dev.twitter.com/rest/public).

Time spent: **20+** hours spent in total

## User Stories

The following **required** functionality is completed:

- [x] User can **sign in to Twitter** using OAuth login
- [x]	User can **view tweets from their home timeline**
  - [x] User is displayed the username, name, and body for each tweet
  - [x] User is displayed the [relative timestamp](https://gist.github.com/nesquena/f786232f5ef72f6e10a7) for each tweet "8m", "7h"
- [x] User can refresh tweets timeline by pulling down to refresh

The following **optional** features are implemented:

- [x] User can view more tweets as they scroll with infinite pagination 
- [x] Improve the user interface and theme the app to feel "twitter branded"
- [x] Links in tweets are clickable and will launch the web browser
- [ ] User can tap a tweet to display a "detailed" view of that tweet
- [ ] User can see embedded image media within the tweet detail view
- [ ] User can watch embedded video within the tweet
- [ ] User can open the twitter app offline and see last loaded tweets
- [ ] On the Twitter timeline, leverage the CoordinatorLayout to apply scrolling behavior that hides / shows the toolbar.

The following **additional** features are implemented:


- [ ] List anything else that you can get done to improve the app functionality!
- [x] Move the "Compose" action to a FloatingActionButton instead of on the AppBar. 

## Video Walkthrough

Here's a walkthrough of implemented user stories:

Login:<br>
<img src='https://github.com/kallytang/SimpleTweet/blob/master/login.gif' title='Login'/><br>
 Infinite Scroll(plus timestamp): <br>
<img src='https://github.com/kallytang/SimpleTweet/blob/master/infinite_scroll.gif' title='Infinite Scroll'  /><br>
Pull down to refresh:<br>
<img src='https://github.com/kallytang/SimpleTweet/blob/master/refresh_button.gif' title='Refresh Button'  /><br>


GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Notes

I made the twitter screen similar to the current twitter application. I had some trouble with vectors, realized i can't convert png files into files that could be used for xml vectors. There's some images/icons that were missing and i had to create the comment icon myself. 

upload icon is from https://icons-for-free.com/box+document+outline+share+top+upload+icon-1320195323221671611/  

## Open-source libraries used

- [Android Async HTTP](https://github.com/codepath/CPAsyncHttpClient) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Android

## License

    Copyright [2020] [name of copyright Kally Tang]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
