# Online-Voting-System-using-Java
lightweight Online Voting System implemented in Java using JDBC for database connectivity. The system provides separate modules for user registration, user login, admin login, party management, casting votes (one vote per user per election), viewing results and determining the winner. This README explains how to set up, run and maintain the project.
Tech stack

Java (JDK 8+)

JDBC (MySQL Connector/J or other RDBMS driver)

MySQL (or compatible relational DB)

Optional: Maven for build and dependency management
\Features

User registration

User login

Admin login (built-in credentials)

Add / list parties (admin)

Cast vote (users — one vote per user per election)

Show results and winner (admin)

Prevent duplicate voting (unique constraint per user+election)

Timestamps for votes
CREATE DATABASE online_voting;
USE online_voting;


-- users table
CREATE TABLE users (
id INT AUTO_INCREMENT PRIMARY KEY,
username VARCHAR(100) NOT NULL UNIQUE,
password VARCHAR(255) NOT NULL,
full_name VARCHAR(255),
email VARCHAR(255),
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


-- parties table
CREATE TABLE parties (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255) NOT NULL UNIQUE,
symbol VARCHAR(255),
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


-- elections table (optional, for multi-election support)
CREATE TABLE elections (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255) NOT NULL,
start_date DATE,
end_date DATE,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


-- votes table
CREATE TABLE votes (
id INT AUTO_INCREMENT PRIMARY KEY,
voter_id INT NOT NULL,
candidate_id INT NOT NULL,
election_id INT NOT NULL,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
UNIQUE KEY uniq_vote (voter_id, election_id),
FOREIGN KEY (voter_id) REFERENCES users(id) ON DELETE CASCADE,
FOREIGN KEY (candidate_id) REFERENCES parties(id) ON DELETE CASCADE,
FOREIGN KEY (election_id) REFERENCES elections(id) ON DELETE CASCADE
);
