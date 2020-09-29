# User Guide

Duke is a working todo-list for managing your tasks, using the Command Line Interface (CLI). 

* [Quick Start](#quick-start)
* [Features](#features)
    + [1. help](#1-help)
    + [2. todo](#2-todo)
    + [3. deadline](#3-deadline)
    + [4. event](#4-event)
    + [5. list](#5-list)
    + [6. done](#6-done)
    + [7. delete](#7-delete)
    + [8. due](#8-due)
    + [9. find](#9-find)
    + [10. bye](#10-bye)
* [Command Summary](#command-summary)

## Quick Start

1. Ensure that you have java *11* installed in your computer
2. Download duke.jar to a folder
3. Navigate to the folder in command prompt and run it with `java -jar duke.jar`
4. Type `help` to see a list of commands for Duke

## Features

Duke can do the following:
* `help`: Provides a list of commands and their syntax
* `list`: List all tasks
* `todo`: Add a todo to your task list
* `deadline`: Add a deadline to your task list
* `event`: Add an event to your task list
* `done`: Mark an existing task as done
* `delete`: Deletes an existing task
* `find`: Find tasks that contain the keyword
* `due`: Find tasks that are due on that date
* `bye`: Ends the program

### 1. help

Prints all available commands and their syntax

Example of usage: 

`help`

### 2. todo

Adds a task to the task list.

Example of usage: 

`todo Study for test`


### 3. deadline 

Adds a task with deadline to the task list.
Deadline entered can be either as plain text or as a date in YYYY-MM-DD format.

Example of usage: 

`deadline wash clothes /by today`

`deadline learn chicken recipe /by 2020-09-30`

### 4. event

Adds an event with time it occurs to the task list.
Time for the event entered can be either as plain text or as a date in YYYY-MM-DD format.

Example of usage: 

`event watch movie with friends /at 2020-10-01`

`event meeting /at tommorow`

### 5. list

List out all tasks in the task list with their completion status and index.

Example of usage: 

`list`

### 6. done

Marks task on the list at the index entered as completed.

Example of usage: 

`done 3`

### 7. delete

Deletes the task on the list at the index entered.

Example of usage: 

`delete 3`

### 8. due

Returns all tasks that are due on date entered.

Date entered can be in plain text or YYYY-MM-DD format.

Example of usage: 

`due 2019-09-10`

`due today`

### 9. find

Find tasks that contains the keyword entered by user.

Example of usage: 

`find books`

### 10. bye

Ends the program.

Example of usage: 

`bye`

## Command Summary

Command | Format | Example
------- | ---------- | ------------
help | `help` | -
todo | `todo [task description]` | `todo cook`
deadline | `deadline [task description] /by [date in string or YYYY-MM-DD]`| `deadline do homework /before tomorrow`
event | `event [task description] /at [date in string or YYYY-MM-DD]` | `event Movie with friends /at 2020-01-10`
list | `list` | -
done | `done [index of task in list]`  | `done 3`
delete | `delete [index of task in list]` | `delete 3`
due | `due [date in string or YYYY-MM-DD]` | `due today`
find | `find [keyword]` | `find books`
bye | `bye` | -