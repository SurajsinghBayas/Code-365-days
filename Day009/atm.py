class Account:
    def __init__(self):
        self._pin_number = None
        self._customer_number = None
        self.current_balance = 2000.0
        self.saving_balance = 1000.0

    def set_customer_number(self, cn):
        self._customer_number = cn

    def set_pin_number(self, pn):
        self._pin_number = pn

    def get_customer_number(self):
        return self._customer_number

    def get_pin_number(self):
        return self._pin_number

    def format_inr(self, amount):
        return f"{amount:,.2f} ₹"

    def format_usd(self, amount):
        return f"{amount:,.2f} $"

    def get_current_balance(self):
        print(f"Current Available Balance is: {self.format_inr(self.current_balance)}")

    def get_saving_balance(self):
        print(f"Saving Available Balance is: {self.format_usd(self.saving_balance)}")

    # Current account withdraw
    def current_withdraw_input(self):
        print(f"\nCurrent Available Balance is: {self.format_inr(self.current_balance)}")
        amount = float(input("Enter Amount To Withdraw: "))
        if (self.current_balance - amount) > 0:
            self.calc_current_withdraw(amount)
            print(f"\nCurrent Available Balance is: {self.format_inr(self.current_balance)}")
        else:
            print("Insufficient Balance")
            self.current_withdraw_input()

    def calc_current_withdraw(self, amt):
        self.current_balance -= amt
        return self.current_balance

    # Current account deposit
    def current_deposit_input(self):
        amount_deposit = float(input("Enter Amount to deposit: "))
        if amount_deposit > 0:
            self.calc_current_deposit(amount_deposit)
            print(f"\nCurrent Available Balance is: {self.format_inr(self.current_balance)}")
        else:
            print("Invalid Amount")
            self.current_deposit_input()

    def calc_current_deposit(self, amt):
        self.current_balance += amt
        return self.current_balance

    # Saving account withdraw
    def saving_withdraw_input(self):
        print(f"\nSaving Available Balance is: {self.format_usd(self.saving_balance)}")
        amount = float(input("Enter Amount To Withdraw: "))
        if (self.saving_balance - amount) > 0:
            self.calc_saving_withdraw(amount)
            print(f"\nSaving Available Balance is: {self.format_usd(self.saving_balance)}")
        else:
            print("Insufficient Balance")
            self.saving_withdraw_input()

    def calc_saving_withdraw(self, amt):
        self.saving_balance -= amt
        return self.saving_balance

    # Saving account deposit
    def saving_deposit_input(self):
        amount_deposit = float(input("Enter Amount to deposit: "))
        if amount_deposit > 0:
            self.calc_saving_deposit(amount_deposit)
            print(f"\nSaving Available Balance is: {self.format_usd(self.saving_balance)}")
        else:
            print("Invalid Amount")
            self.saving_deposit_input()

    def calc_saving_deposit(self, amt):
        self.saving_balance += amt
        return self.saving_balance


class OptionMenu(Account):
    def __init__(self):
        super().__init__()
        self.credentials = {
            11111: 111,
            11112: 222,
            11113: 333,
            11114: 444,
            11115: 111
        }

    def get_login(self):
        while True:
            try:
                print("Welcome to my ATM")
                print("Enter Customer Number")
                self.set_customer_number(int(input()))
                print("Enter Pin Number")
                self.set_pin_number(int(input()))

                customer_num = self.get_customer_number()
                pin_num = self.get_pin_number()

                if customer_num in self.credentials and self.credentials[customer_num] == pin_num:
                    print("Login Successful")
                    self.get_account_type()
                    break
                else:
                    print("Incorrect Customer Number or Pin Number")

            except ValueError:
                print("\nEnter Only Numbers")
                print("\nCharacters and Special Symbols are not allowed")

    def get_account_type(self):
        print("Select The Account Type")
        print("Choice : 1.Current Account 2.Saving Account 3.Exit")
        choice = int(input("Choice: "))

        if choice == 1:
            self.get_current()
        elif choice == 2:
            self.get_saving()
        elif choice == 3:
            print("Visit Again\n")
        else:
            print("Invalid Choice")
            self.get_account_type()

    def get_current(self):
        print("\n Current Account")
        print("\n Choice 1: Balance Enquiry")
        print("\n Choice 2: Withdraw Money")
        print("\n Choice 3: Deposit Money")
        print("\n Choice 4: Exit")
        c = int(input("Choice: "))

        if c == 1:
            self.get_current_balance()
            self.get_account_type()
        elif c == 2:
            self.current_withdraw_input()
            self.get_account_type()
        elif c == 3:
            self.current_deposit_input()
            self.get_account_type()
        elif c == 4:
            print("Visit Again\n")
        else:
            print("Invalid Choice")
            self.get_current()

    def get_saving(self):
        print("\n Saving Account")
        print("\n Choice 1: Balance Enquiry")
        print("\n Choice 2: Withdraw Money")
        print("\n Choice 3: Deposit Money")
        print("\n Choice 4: Exit")
        c = int(input("Choice: "))

        if c == 1:
            self.get_saving_balance()
            self.get_account_type()
        elif c == 2:
            self.saving_withdraw_input()
            self.get_account_type()
        elif c == 3:
            self.saving_deposit_input()
            self.get_account_type()
        elif c == 4:
            print("Visit Again")
        else:
            print("Invalid Choice")
            self.get_saving()


if __name__ == "__main__":
    op = OptionMenu()
    op.get_login()
    #op.get_account_type()
