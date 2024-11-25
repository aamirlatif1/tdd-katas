
Here’s a practical case study to practice for a TDD-based live-coding interview that you can complete in about an hour:

## Case Study: Banking Transactions System
**Description:** Develop a basic banking system where users can perform transactions like depositing, withdrawing, and checking their account balance.

Requirements:
1. Deposit Money:
   - Users can deposit a positive amount into their account.
   - Reject deposits with negative or zero values.

2. Withdraw Money:
   - Users can withdraw money if the amount is less than or equal to their current balance.
   - Reject withdrawals that exceed the balance or are non-positive.

3. Check Balance:
   - Users can check their current balance at any time.

4. Transaction History:
   - Maintain a history of transactions (e.g., deposit, withdrawal) with timestamps.