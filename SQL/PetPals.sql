show databases;
create database PetPals;
show databases;
use PetPals;
show tables;

CREATE TABLE Pet (
    pet_id INT PRIMARY KEY AUTO_INCREMENT ,
    name VARCHAR(255),
    age INT,
    breed VARCHAR(255)
);

CREATE TABLE Dog (
    pet_id INT PRIMARY KEY,
    dog_breed VARCHAR(255),
    FOREIGN KEY (pet_id) REFERENCES Pet(pet_id)
);

CREATE TABLE Cat (
    pet_id INT PRIMARY KEY,
    cat_color VARCHAR(255),
    FOREIGN KEY (pet_id) REFERENCES Pet(pet_id)
);

CREATE TABLE PetShelter (
    shelter_id INT PRIMARY KEY ,
	pet_id INT,
    FOREIGN KEY (pet_id) REFERENCES Pet(pet_id)
);

CREATE TABLE Donation (
    donation_id INT PRIMARY KEY AUTO_INCREMENT,
    donor_name VARCHAR(255),
    amount DECIMAL(10, 2)
);

CREATE TABLE CashDonation (
    donation_id INT PRIMARY KEY,
    donation_date DATETIME,
    FOREIGN KEY (donation_id) REFERENCES Donation(donation_id)
);

CREATE TABLE ItemDonation (
    donation_id INT PRIMARY KEY,
    item_type VARCHAR(255),
    FOREIGN KEY (donation_id) REFERENCES Donation(donation_id)
);

CREATE TABLE AdoptionEvent (
    event_id INT PRIMARY KEY ,
    event_date DATE,
    event_location VARCHAR(255)
   
);

CREATE TABLE EventParticipants (
    event_id INT,
    participant_id INT PRIMARY KEY AUTO_INCREMENT,
    participant_name VARCHAR(255),
    FOREIGN KEY (event_id) REFERENCES AdoptionEvent(event_id)
);

CREATE TABLE Adoptions(
	pet_name VARCHAR(255), 
    adopter_name VARCHAR(255), 
    adoption_date VARCHAR(255)
);
-- Inserting values into Pet table
INSERT INTO Pet (pet_id, name, age, breed) VALUES
(1, 'Max', 2, 'Labrador'),
(2, 'Fluffy', 1, 'Persian'),
(3, 'Rocky', 4, 'German Shepherd'),
(4, 'Mittens', 3, 'Ragdoll'),
(5, 'Charlie', 2, 'Dachshund');

-- Inserting values into Dog table
INSERT INTO Dog (pet_id, dog_breed) VALUES
(1, 'Mixed Breed'),
(3, 'Husky');

-- Inserting values into Cat table
INSERT INTO Cat (pet_id, cat_color) VALUES
(4, 'Calico'),
(5, 'Black');

-- Inserting values into PetShelter table
INSERT INTO PetShelter (shelter_id, pet_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

-- Inserting values into Donation table
INSERT INTO Donation (donation_id, donor_name, amount) VALUES
(1, 'Alice Johnson', 30.0),
(2, 'Bob Williams', 20.0),
(3, 'Eva Davis', 15.0),
(4, 'Michael Brown', 40.0),
(5, 'Sophia Miller', 25.0);

-- Inserting values into CashDonation table
INSERT INTO CashDonation (donation_id, donation_date) VALUES
(1, '2023-05-10 08:15:00'),
(2, '2023-05-12 14:30:00'),
(3, '2023-05-15 09:45:00'),
(4, '2023-05-18 11:00:00'),
(5, '2023-05-20 16:20:00');

-- Inserting values into ItemDonation table
INSERT INTO ItemDonation (donation_id, item_type) VALUES
(2, 'Blankets'),
(3, 'Collars'),
(4, 'Toys'),
(5, 'Food'),
(1, 'Litter');

-- Inserting values into AdoptionEvent table
INSERT INTO AdoptionEvent (event_id, event_date, event_location) VALUES
(1, '2023-06-01', 'City Park Adoption Day'),
(2, '2023-06-15', 'Downtown Shelter Event');

-- Inserting values into EventParticipants table
INSERT INTO EventParticipants (event_id, participant_id, participant_Name) VALUES
(1, 1, "Rupa"),
(1, 2, "Mohan"),
(2, 3, "Mahesh"),
(2, 4, "Gayatri"),
(2, 5, "Sai");

drop table EventParticipants;
drop table AdoptionEvent;
drop table ItemDonation;
drop table CashDonation;
drop table Donation;
drop table PetShelter;
drop table Cat;
drop table Dog;
drop table Pet;

select * from Pet;
select * from Donation;
select * from EventParticipants;
select * from Adoptions;
