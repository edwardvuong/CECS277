# Design Patterns Assignment
For this assignment, you will be using some of the design patterns we discussed:
Singleton
Decorator
Factory
Observer

You will use these patterns in creating a Roach Motel.
There can be only one Roach Motel. 
The Roach Motel will be created with an initial capacity (number of rooms).

When the motel is full, turn on the no vacancy sign. Otherwise the vacancy sign should be shown.

Each of the rooms start out at the base rate but you can add amenities only when a customer checks in. Your customer will be a Roach Colony.

A Roach Colony has a name, an initial population, and a growth rate.
The base rate of a regular room is $50 per night.
The base rate of a deluxe room is $75 per night.
The base rate of a suite is $100 per night.

The amenities include:
A food bar - add $10 per night
A spa - add $20 per night
Autorefill of the food bar - add $5 per night
Spray resistant shower - add $25 dollars per night

Roaches like to throw parties. Everytime they invite friends, the number of occupants in the room increase by their growth factor.

Whenever a RoachColony throws a party, the party is sprayed with insecticide. If the room has an antispray shower, the number of roaches is reduced by 25%. Without the shower, the number of roaches is reduced by 50%.

When the roaches check out, we calculate the bill as the room rate mulitplied by the numbers of days that the RoachColony has been our guest. Then we make that room available.

If a RoachColony tries to check in and there are no available rooms, we add them to a waitlist.

When a room does become vacant, we notify every colony on the list then clear out the list.

When the colony receives the notification, the colony will display a message that the notification has been received.
