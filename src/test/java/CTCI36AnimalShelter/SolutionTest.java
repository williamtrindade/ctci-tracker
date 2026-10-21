package CTCI36AnimalShelter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

class SolutionTest {

    @Test
    void dequeueAnyReturnsOldestAnimal() {
        Solution.AnimalShelter shelter = new Solution.AnimalShelter();
        Dog rex = new Dog("Rex");
        Cat tom = new Cat("Tom");
        Dog bob = new Dog("Bob");
        shelter.enqueue(rex);
        shelter.enqueue(tom);
        shelter.enqueue(bob);
        assertSame(rex, shelter.dequeueAny());
        assertSame(tom, shelter.dequeueAny());
        assertSame(bob, shelter.dequeueAny());
        assertNull(shelter.dequeueAny());
    }

    @Test
    void dequeueByTypeReturnsOldestOfThatType() {
        Solution.AnimalShelter shelter = new Solution.AnimalShelter();
        Cat c1 = new Cat("c1");
        Dog d1 = new Dog("d1");
        Cat c2 = new Cat("c2");
        Dog d2 = new Dog("d2");
        shelter.enqueue(c1);
        shelter.enqueue(d1);
        shelter.enqueue(c2);
        shelter.enqueue(d2);
        assertSame(d1, shelter.dequeueDog());
        assertSame(c1, shelter.dequeueAny());
        assertSame(c2, shelter.dequeueAny());
        assertNull(shelter.dequeueCat());
        assertSame(d2, shelter.dequeueAny());
    }

    @Test
    void emptyOrMissingTypeReturnsNull() {
        Solution.AnimalShelter shelter = new Solution.AnimalShelter();
        assertNull(shelter.dequeueAny());
        assertNull(shelter.dequeueDog());
        assertNull(shelter.dequeueCat());
        Dog d = new Dog("d");
        shelter.enqueue(d);
        assertNull(shelter.dequeueCat());
        assertSame(d, shelter.dequeueDog());
    }

    @Test
    void interleavedOperations() {
        Solution.AnimalShelter shelter = new Solution.AnimalShelter();
        Dog d1 = new Dog("d1");
        Dog d2 = new Dog("d2");
        Cat c1 = new Cat("c1");
        shelter.enqueue(d1);
        shelter.enqueue(d2);
        assertSame(d1, shelter.dequeueAny());
        shelter.enqueue(c1);
        assertSame(c1, shelter.dequeueCat());
        Cat c2 = new Cat("c2");
        shelter.enqueue(c2);
        assertSame(d2, shelter.dequeueAny());
        assertSame(c2, shelter.dequeueAny());
    }
}
