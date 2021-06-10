// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */
function addRandomGreeting() {
  const greetings =
      ['I love to cook!', 'I am on a hiphop team!', 'I am Mexican & Colombian', 'I love to travel'];

  // Pick a random greeting.
  const greeting = greetings[Math.floor(Math.random() * greetings.length)];

  // Add it to the page.
  const greetingContainer = document.getElementById('greeting-container');
  greetingContainer.innerText = greeting;
}

//do fetch 
async function fetchMessage() {
    //fetch info (response) from servlet 
    const responseFromServer = await fetch('/hello');
    const textFromResponse = await responseFromServer.json();

 // UNABLE TO ACCESS MESSAGES: Hello!, Hola!, or Namaste! indivually. Only prints  
 // as one string "Hello!,Hola!,Namaste!"
 /////////////////////////////////////////////////////////////////////////////// 
   // const messageToPrint= textFromResponse.get(0);
   // const messageContainer = document.getElementById('message-container');
   // messageContainer.innerText = messageToPrint;



//CONSOLE.LOG DID NOT WORK. Nothing printed with these two lines of code  
//////////////////////////////////////////////////////////////////////////////
   // console.log(textFromResponse.phrases.get(0));
   // console.log(textFromResponse); 
    
    //add json sting to the page. prints:  "Hello!,Hola!,Namaste!"
    const messageContainer = document.getElementById('message-container');
    messageContainer.innerText = textFromResponse;  
}
