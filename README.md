# Online-Voting-System-using-Java
ightweight Online Voting System implemented in Java using JDBC for database connectivity. The system provides separate modules for user registration, user login, admin login, party management, casting votes (one vote per user per election), viewing results and determining the winner. This README explains how to set up, run and maintain the project.
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
