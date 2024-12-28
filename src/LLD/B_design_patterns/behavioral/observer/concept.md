## Observer Design Pattern: (also known as Event-Subscriber, Listener)
```text
    This pattern lets you define a subscription mechanism to notify multiple objects about any events that happen
to the object they are observing.
```

```text
Problem(briefly):
    - Customers of a store wanted to know whether the new version of iPhone is available or not.
    - If customer goes to the store everyday and if the iphones are still in transit, then his visits to store are wasted.
    - If store sends email to all the customers, then customers who are not interested in this new iphone feel that
      these emails are kind of spam and also it is a waste of resources to store to send emails to everyone.

Solution(briefly):
    - Use the observer design pattern, so that interested customers can subscribe to the state changes of store and only
      they can be emailed about any new events happening at the store.
```

```text
The object whose change needs to be monitored is known as Subject

Publisher - The subject that notifies the observers who are observing for its state changes is known as Publisher
Subscriber - The object that is interested in observing the state changes of a subject is known as Subscriber
```

### Multiple Scenarios
1. **<u>One publisher and many subscribers</u>:** If you have a single publisher and many subscribers who want to observe the
    events that happen in the publisher, then you can have the list of subscribers directly inside the publisher and
    whenever an event happens in the publisher, then the publisher can iterate through the list of observers which it
    has and notify each observer by calling their notify method.

2. **<u>Multiple publishers and many subscribers who want to subscribe to events in these publishers</u>:** If you have
    multiple subscribers who want to observe the events that happen in all of these publishers, then instead of
    having the subscribers list in each publisher, we can delegate this responsibility to an Event Dispatcher that has
    a HashMap<EventType, Observer> and this holds a mapping which eventType each observer wants to observe. Whenever an
    event occurs in a publisher, it will call the EventDispatcher's notifySubscribers(eventType, data) method with the 
    respective eventType string. Then, the event dispatcher iterates through all of its subscribers and notify each
    subscriber with the data if that subscriber is subscribed to that event.

> Example implementations for both of these scenarios can be found in scenario_1 and scenario_2 folder. In scenario 2,
we are subscribing the users to events directly using EventDispatcher. But, we can also do this through publishers,
and it is completely upto the developer's choice where to implement this.

```text
Applicability:
    - Use the observer pattern when changes to the state of one object may require changing other objects, and the 
      actual set of objects is unknown beforehand or changes dynamically.
    - Use the pattern when some objects in your app must observe others, but only for a limited time or in specific cases.
```

```text
Pros:
    - Open/Closed Principle. You can introduce new subscriber classes without having to change the publisher's code.
    - You can establish relationships between objects at runtime.
```

```text
Cons:
    - Subscribers are notified in random order
```

    

