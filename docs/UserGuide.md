---
layout: page
title: User Guide
---
## Welcome to PharmHub!

--------------------------------------------------------------------------------------------------------------------

***Where Precision Meets Prescription***

Pharmhub is a **desktop app for managing patients and their medication orders, optimized for use via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, PharmHub can get your patient/ order management tasks done faster than traditional GUI apps.

--------------------------------------------------------------------------------------------------------------------
## Table of Contents
1. [Glossary](#glossary)
    1. [Person](#person)
    2. [Order](#order)
    3. [Status](#status)
    4. [Medicine](#medicine)
    5. [Index](#index)
    6. [Fields](#fields)
2. [Application Navigation](#application-navigation)
3. [Quick Start](#quick-start)
4. [Features](#features)
5. [FAQ](#faq)

--------------------------------------------------------------------------------------------------------------------

## Glossary

### Person

For the entire user guide the term person is used to refer to the patient of which the pharmacist is addressing to.
Persons are the people with whom you track your Orders and information for. To create an order with a person, they must first have been added to the app.

A person has the following attributes:
- Name
- Phone number
- Email Address
- Address
- Allergy(If the person has one)

Persons are uniquely identified by their names. No two persons can have the same name and names are case-insensitive.

### Order

Orders are event in which an order has been placed for a single or multiple medication for a certain person in the person list.

An Order has the following attributes:
- Order Number
- Person (Who the order belongs to)
- Medicine (What is in the order)
- Status of the order

Orders are uniquely identified by their order numbers. No two orders can have the same order number. 
No orders containing the medicine that the person is allergy to can be added without a special flag.
Orders will automatically tag under the <span style="color: red;">PENDING</span>
Status when added.

### Status

Status are used to describe the process at which the order is at.
Status can only be updated/modified following their chronological order.

<span style="background-color: red; border-radius: 20%; padding: 1px; color: white">PENDING/PD</span>
->
<span style="background-color: blue; border-radius: 20%; padding: 1px; color: white">PREPARING/PR</span>
->
<span style="background-color: green; border-radius: 20%; padding: 1px; color: white">COMPLETED/CP</span>
->
<span style="background-color: black; border-radius: 20%; padding: 1px; color: white">CANCELED/CC</span>

Status can be identified either in their full form or in their short form as shown above (FullForm/ShortForm). Status are all case-insensitive as well.

### Medicine

Medicine are objects that can be added to an order when it is being placed for a person.

A Medicine has the following attribute:
- Full Name of the medication
- A optional short form for the medication

Medicine are uniquely identified by their full and short form names. No two medicine can have the same names.

### Index

All commands will be executed base on Index. Index refer to the numbering being shown in the person/order/medicine list.
All index can only be more than 0, at least 1.

As you can refer to the image below index 1 refer to OrderNumber #1 while index 3 refer to OrderNumber #5.

![listp](images/listo.png)

Note: The Index will be base on the command being called and not the displayed list, 
if a command of viewp(view person) is being called, 
the index taken will be base on the person list and not this list being shown currently.

### Fields
Inputs to fields should not contain an number of "/" sign. i.e "//" is allowed

The following fields are used for commands:

| Field         | Prefix            | Format                                                       | Example                               |
|---------------|-------------------|--------------------------------------------------------------|---------------------------------------|
| Index         | -                 | Must be a positive integer                                   | `1`, `2`, `3`                         |
| Keyword       | -                 | Must not contain a singular "/" sign                         | `pan`, `Ah Tan s//o Ah Tan Tan`       |
| Name          | n                 | Must be alphanumeric                                         | `Joe`, `Vishnu`                       |
| Phone number  | p                 | Must be numeric and be at least 3 digits long                | `999`, `68741616`                     |
| Email address | e                 | Must be a valid email address                                | `pharmhub@bestapp.sg`, `putin@russia` |
| Address       | a                 | Must not contain a singular "/" sign                         | `Sentosa cove`, `Pulau NTU`           |
| Status        | [Status](#status) | Must be a valid Status                                       | `PENDIND`, `Cc`                       |
| Commands      | -                 | Must be the first input, case-insensitive                    | `addo`, `listm`                       |


---

## Application Navigation

Below shows a guide on how you can navigate around our beautiful Graphical User Interface (GUI)

![Navigation](images/navigation.png)

| Component                  | Description                                                 | Remarks                                                          |
|----------------------------|-------------------------------------------------------------|------------------------------------------------------------------|
| Help Button                | Shows URL to our User Guide.                                | -                                                                |
| Command Input Field        | Type commands here and press `Enter` to execute them.       | -                                                                |
| Command Output Display     | Shows the result of the command execution.                  | -                                                                |
| Person Information Display | Shows Detailed information on a person.                     | Displays Name, Email, allergy and Orders under this person.      |
| PersonList                 | Shows a list of person.                                     | List can be filtered by Keywords in the names.                   |
| Person Card                | Shows a particular person with minimal details in the list. | Shows the Name, Allergies, Number, Address and Email.            |
| Order Information Display  | Shows Detailed information on an order.                     | Displays status, Order Number, Person of the order and Medicine. |
| Order List                 | Shows a list of orders.                                     | List can be filtered by Status or Medicine in the order or Both. |
| Order Card                 | Shows a particular order with minimal details in the list.  | Shows Order Number, Name, Address and Medicine.                  |
| Medicine List              | Shows a list of medicine in the system.                     | List can be filtered by Keywords in the medicines.               |
| Medicine Card              | Shows a particular medicine with all the details.           | Shows the Full and Short form of the medicine.                   |

---

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

2. Download the latest `PharmHub.jar` from [here](https://github.com/AY2324S1-CS2103T-W08-4/tp/releases).

3. Copy the file to the folder you want to use as the _home folder_ for your PharmHub.

4. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar pharmhub.jar` command to run the application.<br>
   A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

5. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * `listp` : Lists all people.
   
   * `listo` : Lists all order.
   
   * `listm` : Lists all medicine.
   
   * `viewp 1` : views in detail index 1 of the person list.(The Displayed list does not have to be person to view person)

   * `viewo 1` : views in detail index 1 of the order list.

   * `addp n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01` : Adds a person named `John Doe` to PharmHub.

   * `deletep 3` : Deletes the 3rd patient shown in the current list.

   * `clear` : Deletes all people.

   * `exit` : Exits the app.

6. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `addp n/NAME`, `NAME` is a parameter which can be used as `addp n/John Doe`.  
* Spaces before and after parameter will be ignored.  
  If there is more than one space in between words in the parameter, it will be trimmed to one space.  
  e.g `addp n/ Alex Yeoh` will produce the same result as `addp n/ Alex     Yeoh`
* To input a `/` character in parameter, use another `/` before it.  
  If there is an odd number of `/`, one of them will be ignored.  
  e.g To input `Roy s/o Balakrishnan`, use `Roy s//o Balakrishnan`

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/friend`, `t/friend t/family` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
</div>

### Viewing help : `help`

Shows a message explaining how to access the help page.

![help message](images/helpMessage.png)

Format: `help`


### Adding a person: `addp`

Adds a person to PharmHub.

Format: `addp n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG] [no/ALLERGY]…​`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A person can have any number of tags or allergies (including 0)
</div>

Examples:
* `addp n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01 no/paracetamol no/aspirin`
* `addp n/Betsy Crowe t/friend e/betsycrowe@example.com a/Newgate Prison p/1234567 t/criminal`

### Listing all persons : `listp`

Shows an interactive list of all persons in PharmHub.

Format: `listp`

![listp](images/listp.png)

### Viewing a person `viewp`

Displays the specified person with more details in the info panel.

Format: `viewp INDEX`

Examples:
* `listp` followed by `viewp 2` opens the 2nd person in the list into the info panel.

### Editing a person : `editp`

Edits an existing person in the PharmHub.

Format: `editp INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG] [no/ALLERGY]…​ [ia/]`

* Edits the person at the specified `INDEX`. The index refers to the index number shown in the displayed person list. The index **must be a positive integer** 1, 2, 3, …​
* This also edits orders belonging to the person.
* At least one of the optional fields must be provided.
* This command will not be able to add/delete orders to this person
* Existing values will be updated to the input values.
* When editing tags or allergies, the existing tags or allergies of the person will be removed i.e adding of tags is not cumulative.
* You can remove all the person’s tags by typing `t/` without
    specifying any tags after it.
* You can remove all the person’s allergies by typing `no/` without
    specifying any allergies after it.
* If the editing causes the person to be allergic any of the orders belonging to them, warning will be raised.
* Use the `ia/` flag to override.

Examples:
*  `editp 1 p/91234567 e/johndoe@example.com` Edits the phone number and email address of the 1st person to be `91234567` and `johndoe@example.com` respectively.
*  `editp 2 n/Betsy Crower t/` Edits the name of the 2nd person to be `Betsy Crower` and clears all existing tags.
*  `editp 3 no/` Edits the allergies of the 3rd person to be empty.

### Locating persons by name: `findp`

Finds persons whose names contain any of the given keywords.

Format: `findp KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g `hans` will match `Hans`
* The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`
* Only the name is searched.
* Only full words will be matched e.g. `Han` will not match `Hans`
* Persons matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`

Examples:
* `findp John` returns `john` and `John Doe`
* `findp alex david` returns `Alex Yeoh`, `David Li`<br>
  ![result for 'find alex david'](images/findAlexDavidResult.png)

### Deleting a person : `deletep`

Deletes the specified person from PharmHub.

Format: `deletep INDEX`

* Deletes the person at the specified `INDEX`.
* This also deletes orders belong to the person.
* The index refers to the index number shown in the displayed person list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `listp` followed by `deletep 2` deletes the 2nd person in the address book.
* `findp Betsy` followed by `deletep 1` deletes the 1st person in the results of the `find` command.

### Adding a new medicine : `addm`

Adds a new medication into the system.  

Format: `addm m/MEDICINE_NAME`

* The given name shouldn't match the name or short form any medicine in the system.   
* Medicine names are case-insensitive.

### Listing all medicines : `listm`

Shows a list of all medicines in PharmHub.  

Format: `listm`

![listm](images/listm.png)

### Locating a medicine by name : `findm` 

Finds all medicines whose name or short form contains any of the given keywords.  

Format : `findm`

* The search is case-insensitive. e.g `pan` will match `Panadol`
* The medicine name and it's short form is searched.
* Unlike `findp`, partial words will be matched e.g. `para` will  match `Paracetamol`
* Medicines matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `ol en` will return `Panadol`, `Ibuprofen`

### Deleting a medicine : `deletem`

Deletes the specified medicine from PharmHub.

Format: `deletem INDEX`

* Deletes the medicine at the specified `INDEX`.
* The index refers to the index number shown in the displayed medicine list.
* The index **must be a positive integer** 1, 2, 3, …​ 
* The command will be blocked if there are existing orders with the specified medicine 
  or persons allergic to the specified medicine.  

### Adding and Deleting short form : `sfm`

Adds or Deletes a short form from the specified medicine from PharmHub.

Format: `sfm INDEX [m/SHORT_FORM] [d/]`

* If the `d/` is not provided, the given short form will be added to the medicine at the specified `INDEX`.  
* The provided short form must not be same as any existing medicine name or short form in PharmHub.  
* Any existing short form of the medicine will be over written.
* After this, the short form can be used interchangeably with the medicine name.  
* If the `d/` is provided, the short form(if any) of the medicine at the specified `INDEX` will be deleted.  


### Listing all orders : `listo` 

Shows an interactive list of all orders in PharmHub.

Format: `listo`

![listo](images/listo.png)

### Viewing an order : `viewo` 

Shows the order in the info panel.

Format: `viewo`


### Adding a new order : `addo` 

Adds a new order of the given medication(s) corresponding to a person into the system.

Format: `addo INDEX o/ORDER_NUMBER m/MEDICINE_NAME [m/MEDICINE_NAME]…​ [/ia]`

* Orders are created automatically having a `status` of `pending`.
* Orders can only be created for a person in the index range, and for a known `medicine`
* Orders created for persons with an allergy to any of the medications in the order will raise a warning.
* The warning can be overridden by adding the `/ia` to the command

Parameters:
* `INDEX` - index of patient who is ordering the medicine as shown in the patient list.
* `ORDER_NUMBER` - the order number of this order specified by the invoice.
* `MEDICINE_NAME` - the name of medicine being ordered.

Examples:
* `addo 1 o/618457 m/panadol`
* `addo 3 o/438756 m/claritin`


### Updating the status of an order : `updates` 

Updates the status of the order to the designated status.

Format: `updates INDEX s/STATUS`

* Statuses: `Pending (pd) -> Preparing (pr) -> Completed (cp) -> Cancelled (cc)`, in increasing hierarchy
* Statuses can only be updated upwards. Once the status of an order progresses to the next stage, it cannot go back.
* Statuses can be updated by skipping the hierarchy. `Pending -> Cancelled`
* Shorthands can be used in replacement of the full names of the statuses

Example: 
* `updates 1 s/completed`
* `updates 1 s/COMPLETED`
* `updates 1 s/cp`
* `updates 1 s/CP`

### Filtering/Finding Order by status and medicines: `findo`

Finds orders whose status and medicine satisfies both inputs.

Format: `findo s/STATUS m/MEDICINE_NAME [m/MEDICINE_NAME]...`

* The search is case-insensitive. e.g `PANADOL` will match `Panadol`, `COMPLETED` or `CP` will match `Completed`.
* User input can find orders base on either status or medicines or both(but both will have to be satisfied).
* Status can only be `Pending/PD Preparing/PR Completed/CP Cancelled/CC`, any other inputs will be invalid.
* Medicine can be written both in their short form and full form. `pan` will match `Panadol`.
* Multiple Medicine can be used as input separated by a blank space but only one status can be used.
* Orders that contain any one of the medication/Status will be shown.

Examples:
* `findo m/Panadol Ibuprofen` returns any orders with either `Panadol` or `Ibuprofen`.
* `findo s/pd m/Panadol` returns any orders that is both `Pending` and contains `Panadol`.
  ![result for 'findo s/pd m/Panadol'](images/findOrder2Input.png)

### Deleting an order : `deleteo` 

Deletes the specified order from PharmHub.

Format: `deleteo INDEX`

Example: `deleteo 2`


### Undoing an action : `undo` 

Undoes the last data-modifying action.

Format: `undo`

* Limited to last 30 actions.
* Does not undo Ui views (eg. find, view commands). 

Example: 
* `addp` -> `listp` -> `undo` will undo the `addp` command

### Redoing an action (after an undo) : `redo` 

Negates the effect of the last undo.

Format: `redo`

* The undo command must have been the latest data-modifying command.
* Once a non-`undo` data-modifying command is executed, redoing undoes before that non-`undo` command is no longer possible

Example:
* `addp` -> `undo` -> `addp` -> `redo`  will throw an error
* `addp` -> `undo` -> `listp` -> `redo` will redo the `addp` command successfully



### Clearing all entries : `clear`

Clears all entries from PharmHub.

Format: `clear`

### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Saving the data

PharmHub data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

PharmHub data are saved automatically as a JSON file `[JAR file location]/data/pharmhub.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, PharmHub will discard all data and start with an empty data file at the next run. Hence, it is recommended to take a backup of the file before editing it.
</div>


--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous PharmHub home folder.

--------------------------------------------------------------------------------------------------------------------

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.

--------------------------------------------------------------------------------------------------------------------

## Command summary

| Action                    | Format, Examples                                                                                                                                                                                |
|---------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **List People**           | `listp`                                                                                                                                                                                         |
| **Find Person**           | `findp KEYWORD [MORE_KEYWORDS]`<br> e.g., `findp James Jake`                                                                                                                                    |
| **View Person**           | `viewp INDEX` <br> e.g., `viewp 1`                                                                                                                                                              |
| **Add Person**            | `addp n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG] [no/ALLERGY]…​` <br> e.g., `addp n/James Ho p/22224444 e/jamesho@example.com a/123, Clementi Rd, 1234665 t/friend t/colleague no/aspirin` |
| **Edit Person**           | `editp INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG] [no/allergy]…​`<br> e.g.,`editp 2 n/James Lee e/jameslee@example.com`                                                      |
| **Delete Person**         | `deletep INDEX`<br> e.g., `deletep 3`                                                                                                                                                           |
| **List Orders**           | `listo`                                                                                                                                                                                         |
| **Find Order**            | `findo [s/STATUS] [m/MEDICINE_NAME]...`<br> e.g., `findo s/cp m/pen`                                                                                                                            |
| **View Order**            | `viewo ORDER_NUMBER` <br> e.g., `viewo 12345`                                                                                                                                                   |
| **Add Order**             | `addo INDEX o/ORDER_NUMBER m/MEDICINE_NAME [m/MEDICINE_NAME]...` <br> e.g., `addorder 3 o/438756 m/claritin`                                                                                    |
| **Update Order Status**   | `updates INDEX s/STATUS`<br> e.g., `updates s/cancelled`                                                                                                                                        |
| **Delete Order**          | `deleteo INDEX`<br> e.g., `deleteo 3`                                                                                                                                                           |
| **List Medicine**         | `listm`                                                                                                                                                                                         |
| **Find Medicine**         | `findm KEYWORD [MORE_KEYWORDS]`                                                                                                                                                                 |
| **Add Medicine**          | `addm m/MEDICINE_NAME`                                                                                                                                                                          |
| **Delete Medicine**       | `deletem INDEX`                                                                                                                                                                                 |
| **Add/Delete Short Form** | `sfm INDEX [m/SHORT_FORM] [d/]`                                                                                                                                                                 |
| **Undo**                  | `undo`                                                                                                                                                                                          |
| **Redo**                  | `redo`                                                                                                                                                                                          |
| **Clear**                 | `clear`                                                                                                                                                                                         |
| **Help**                  | `help`                                                                                                                                                                                          |
| **Exit**                  | `exit`                                                                                                                                                                                          |

