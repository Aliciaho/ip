# User Guide
Duke is a programme used to store tasks in three different categories: Event, Todo and Deadline. Users can also mark those tasks as done or even delete them. Furthermore, users can find relevant tasks by searching for their keyword.

## Features 

### Feature 1 - Deadline
Users can store deadlines with their respective end dates.

### Feature 2 - To do
Users can store tasks they need to do without any end dates.

### Feature 3 - Event
Users can store events together with the dates of those events

### Feature 4 - Done
Users can mark tasks that they have finished as done.

### Feature 5 - Delete
Users can delete unnecessary tasks from their list.

### Feature 6 - List
Users can list out all their tasks row by row.

### Feature 7 - Find
Users can find the relevant tasks they want by using a keyword

## Usage

### `deadline` - make a new deadline task

Users have to input the description and date of the deadline which will be stored in the Task List.

Example of usage: 

`deadline return book /by Sunday`

Expected outcome:

`Got it. I've added this task:`

    `[D][✗] return book (by: Sunday)`
   
  `Now you have 6 tasks in the list.`

### `todo` - make a new Todo task

Users have to input the description of the Todo which will be stored in the Task List.

Example of usage: 

`todo borrow book`

Expected outcome:

`Got it. I've added this task:`
 
        [T][✗] borrow book
        
      Now you have 5 tasks in the list.`

### `event` - make a new event task

Users have to input the description and date of the event which will be stored in the Task List.

Example of usage: 

`event project meeting /at Mon 2-4pm`

Expected outcome:

`Got it. I've added this task:`
 
        [E][✗] project meeting (at: Mon 2-4pm)
        
      Now you have 7 tasks in the list.`

### `list` - list all the tasks

List out all the tasks in the list which has not been deleted.

Example of usage: 

`list`

Expected outcome:

`  Here are the tasks in your list:`

      1.[T][✓] read book
      2.[D][✓] return book (by: June 6th)
      3.[E][✗] project meeting (at: Aug 6th 2-4pm)
      4.[T][✓] join sports club
      5.[T][✗] borrow book`

### `delete` - delete a task

Users need to input the task number and the respective task is deleted.

Example of usage: 

`delete 3`

Expected outcome:

`   Noted. I've removed this task:`

          `[E][✗] project meeting (at: Aug 6th 2-4pm)
        Now you have 4 tasks in the list.`
        
### `done` - mark the task as finished

Users need to input the task number and the respective task is marked as done.

Example of usage: 

`done 2`

Expected outcome:

 `Nice! I've marked this task as done:`
  
       [✓] return book
  `Now you have 4 tasks in the list.`
  
  ### `find` - find the task you want
  
  Users need to input the keyword of the task they need and a list of tasks with the respective keyword will show up.
  
  Example of usage: 
  
  `find book`
  
  Expected outcome:
  
   `Here are the matching tasks in your list:`
   
         1.[T][✓] read book
         2.[D][✓] return book (by: June 6th)`
         
 ### `bye` - quit the programme
   
   Allows users to exit of the Duke programme
   
   Example of usage: 
   
   `bye`
   
   Expected outcome:
   
    `BYE BYE! SEE YOU NEXT TIME :3!`  