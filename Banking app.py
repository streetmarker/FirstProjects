import random
import sqlite3
conn = sqlite3.connect('card.s3db')
cur = conn.cursor()
cur.execute("""CREATE TABLE IF NOT EXISTS card
            (
            id INTEGER,
            number TEXT,
            pin TEXT,
            balance INTEGER DEFAULT 0
            )""")
conn.commit()


def magic(self, numList):
    s = ''.join(map(str, numList))
    return int(s)
def luhn_algo(self, card):
    cardList = list(card)
    sum = 0
    for x in range(16):
        sum += int(cardList[x])
        if sum % 10 == 0:
            return True
        else:
            return False

class Customer:
    customers = {}
    card_num = None
    pin = None
    account_balance = {}

    def account_menu(self, card):
        for x in range(100):
            print("""1. Balance\n2. Add income\n3. Do transfer
4. Close account\n5. Log out\n0. Exit""")
            choice = int(input())
            if choice == 1:
                cur.execute("""SELECT balance FROM card
                WHERE number = (?)""", (card,))
                print(cur.fetchone())
                conn.commit()
            if choice == 2:
                print("Enter income: ")
                add_money = str(input())
                cur.execute("""UPDATE card
                SET balance = balance + (?)
                WHERE number = (?)""", (add_money, str(card)))
                print("Income was added!")
                conn.commit()
            if choice == 3:
                print("Transfer")
                print("Enter card number:")
                chosen_card = str(input())
                if chosen_card not in self.customers:
                    print("Such a card does not exist.")
                    break
                if not luhn_algo(self, chosen_card):
                    print("Probably you made a mistake in the card number. Please try again!")
                    break
                if card == chosen_card:
                    print("You can't transfer money to the same account!")
                    break
                else:
                    print("Enter how much money you want to transfer:")
                    money_transfer = input()
                    cur.execute("""UPDATE card
                    SET balance =+ (?)
                    WHERE NUMBER = (?)""", (int(money_transfer), chosen_card))


                    conn.commit()
            if choice == 4:
                cur.execute("""DELETE FROM card
                WHERE number = (?)""", (card,))
                conn.commit()
                self.customers.pop(card)
                break
            if choice == 0:
                print("Bye!")
                break


    def accountIdentifier(self, card):  # do ogarniecia smieci
        actualcard = list(card)
        lastdig = actualcard[-1]
        cardList = list(card)

        sum = 0  # sum of numbers

        cardList[-1] = "0"  # checksum

        for x in range(len(cardList)):
            if x % 2 == 0:
                cardList[x] = str(int(cardList[x]) * 2)

        for x in range(len(cardList)):
            if int(cardList[x]) > 9:
                cardList[x] = str(int(cardList[x]) - 9)
        cardList[-1] = lastdig

        for x in range(15):
            sum += int(cardList[x])

        for y in range(0, 10):
            sum += int(y)
            if sum % 10 == 0:
                cardList[-1] = str(y)
                actualcard[-1] = str(y)
                break
            sum -= int(y)

        card = magic(self, actualcard)
        return card

    def menu(self):
        temp = Customer
        for i in range(100):
            print("1. Create an account\n2. Log into account\n0. Exit")
            num = int(input())
            if num == 1:
                print("Your card has been created")
                crdnum = str("400000" + str(random.randint(1000000000, 10000000000)))
                self.card_num = temp.accountIdentifier(self, crdnum)
                print("Your card number:\n" + str(self.card_num))
                self.pin = str(random.randint(1000, 10000))
                print("Your card PIN:\n" + str(self.pin))
                self.customers[self.card_num] = int(self.pin)
                cur.execute("""INSERT INTO card (id, number, pin) 
                            VALUES (?, ?, ?) """,
                            (0, str(self.card_num), str(self.pin)))
                conn.commit()

            if (num == 2):

                print("Enter your card number:")
                get_num = int(input())
                print("Enter your PIN:")
                get_pin = int(input())
                if self.customers.get(get_num) is None:
                    print("Wrong card number or PIN!")
                elif self.customers[get_num] == get_pin:
                    print("You have successfully logged in!")
                    temp.account_menu(self, get_num)

                else:
                    print("Wrong card number or PIN!")
            if (num == 0):
                print("Bye!")
                break


guy = Customer()
guy.menu()
