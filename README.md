# OIBSIP_3

## ATM Program

This repository contains a Java program `ATM.java` that simulates basic ATM functionalities including withdrawals, deposits, transfers, and transaction history.

### Usage

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/Shaswat2208/OIBSIP_3.git
   ```

2. **Compile and Run:**
   ```bash
   cd OIBSIP_3
   javac ATM.java
   java ATM
   ```

### Features

- **User Authentication:** Users are authenticated using a user ID and PIN.
- **Transactions:** Users can view transaction history, deposit, withdraw, and transfer funds between accounts.
- **Simple Interface:** The program provides a command-line interface (CLI) for interacting with the ATM functionalities.

### Example

Suppose we have two users:
- User ID: 1, PIN: 1234, Balance: $1000.0
- User ID: 2, PIN: 5678, Balance: $500.0

To use the ATM program:
1. Enter the User ID and PIN.
2. Select from the available options:
   - 1: View Transactions History
   - 2: Withdraw
   - 3: Deposit
   - 4: Transfer
   - 5: Quit

### Notes

- This program does not persist data beyond the current execution session.
- Ensure Java Development Kit (JDK) is installed to compile and run the program.

Feel free to explore and modify `ATM.java` to suit your needs!
