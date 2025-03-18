
---

# 📦 **Packages**
```java
package customlinkedlist;        // For LL (Singly Linked List)
package customdoublelinkedlist;  // For DLL (Doubly Linked List)
```

---

# 📚 **Class Documentation: Linked List Implementations**

---

## 1️⃣ **Class: `LL` (Custom Singly Linked List)**

### **Overview**
The `LL` class is a **singly linked list** implementation in Java. It allows efficient addition, removal, and search operations. It manages nodes using `head` and `tail` references and keeps track of the size.

---

### ✅ **Key Features**
- Dynamic size (no array resizing needed).
- Efficient insertion/removal at both head and tail.
- Forward traversal.
- Inner `Node` class with `data` and `next` references.
  
---

### ⚙️ **Attributes**
| Modifier  | Type  | Name  | Description                     |
|-----------|-------|-------|---------------------------------|
| `private` | `int`  | `size` | Number of nodes in the list.   |
| `public`  | `Node` | `head` | Reference to the first node.   |
| `public`  | `Node` | `tail` | Reference to the last node.    |

---

### 🏗️ **Constructor**
```java
public LL()
```
- Initializes an empty linked list.
- Sets `head` and `tail` to `null` and `size` to `0`.

---

### 🔧 **Methods**

| Method Signature              | Description                                                            |
|-------------------------------|------------------------------------------------------------------------|
| `public int headvalue()`      | Returns the `data` in the head node (⚠️ may throw `NullPointerException`). |
| `public int tailvalue()`      | Returns the `data` in the tail node.                                   |
| `public void append(int data)`| Appends a node to the end of the list. Time Complexity: O(1).          |
| `public int addNode(int data)`| Adds a node at the front. Returns new size. O(1).                     |
| `public void insert(int data, int index)`| Inserts a node at the given index. O(n).                  |
| `public int remove(int index)`| Removes and returns value at index. O(n).                             |
| `public int pophead()`        | Removes and returns the head node’s value. O(1).                      |
| `public int poptail()`        | Removes and returns the tail node’s value. O(n).                      |
| `public void removetail()`    | Removes the tail node. O(n).                                          |
| `public int findindex(int value)`| Returns index of first node with `value`. O(n).                  |
| `public Node get(int index)`  | Returns node at given index or `null` if invalid. O(n).               |
| `public int length()`         | Returns the number of nodes (`size`).                                 |
| `public void display()`       | Prints list in `data1 -> data2 -> END` format.                        |
| `@Override public String toString()`| Returns the linked list string representation.                 |

---

### 🧩 **Inner Class: `Node`**
```java
private class Node
```

| Modifier | Type  | Name  | Description                         |
|----------|-------|-------|-------------------------------------|
| `int`    | `data`| Holds the node’s data.                    |
| `Node`   | `next`| Points to the next node (forward link).   |

#### Node Constructors:
```java
Node(int data)
Node(int data, Node next)
```

---

### ⚡ **Usage Example**
```java
LL linkedList = new LL();
linkedList.append(10);
linkedList.append(20);
linkedList.addNode(5);
linkedList.insert(15, 2);
linkedList.display(); // 5 -> 10 -> 15 -> 20 -> END
```

---

## 2️⃣ **Class: `DLL` (Custom Doubly Linked List)**

### **Overview**
The `DLL` class is a **doubly linked list** implementation that extends the `LL` class. It supports **bi-directional traversal** and **efficient insertions/deletions** both forward and backward.

---

### ✅ **Key Features**
- Inherits from `LL` and adds **prev** links for double traversal.
- Dynamic size management.
- Supports:
  - Insertion at head, tail, or after a given node.
  - Forward and reverse traversal.
- Inner `Node` class has both `next` and `prev` references.

---

### ⚙️ **Attributes**
| Modifier  | Type  | Name  | Description                    |
|-----------|-------|-------|--------------------------------|
| `private` | `Node` | `head` | First node of the list.       |
| `private` | `Node` | `tail` | Last node of the list.        |
| `private` | `int`  | `size` | Tracks number of nodes.       |

---

### 🏗️ **Constructor**
```java
public DLL()
```
- Initializes an empty doubly linked list.
- `head`, `tail` are `null`; `size` is `0`.

---

### 🔧 **Methods**

| Method Signature                            | Description                                                         |
|---------------------------------------------|---------------------------------------------------------------------|
| `public int getSize()`                      | Returns current size of the list.                                   |
| `public void display()`                     | Displays nodes from head to tail (`data1 -> data2 -> END`).         |
| `public void displayInReverse()`            | Displays nodes from tail to head.                                   |
| `public Node Find(int value)`               | Returns the first node containing `value` or `null`.                |
| `public void insertAfter(int data, int after)` | Inserts node with `data` after node containing `after`.          |
| `public void append(int data)`              | Appends node to the end of the list. Time Complexity: O(n).         |
| `public Node getNode(int index)`            | Returns node at given index or `null` if index is invalid. O(n).    |
| `public void insertfirst(int data)`         | Inserts node at the head of the list. O(1).                         |

---

### 🧩 **Inner Class: `Node`**
```java
public class Node
```

| Modifier | Type  | Name  | Description                       |
|----------|-------|-------|-----------------------------------|
| `int`    | `data`| Node’s data.                            |
| `Node`   | `next`| Points to next node (forward link).     |
| `Node`   | `prev`| Points to previous node (backward link).|

#### Node Constructors:
```java
Node(int data)
Node(int data, Node next, Node prev)
```

---

### ⚡ **Usage Example**
```java
DLL doublyLinkedList = new DLL();
doublyLinkedList.append(10);
doublyLinkedList.insertfirst(5);
doublyLinkedList.append(20);
doublyLinkedList.insertAfter(15, 10);

doublyLinkedList.display(); // 5 -> 10 -> 15 -> 20 -> END
doublyLinkedList.displayInReverse(); // 20 -> 15 -> 10 -> 5 -> END
```

---

## 🎯 **Suggestions to Improve Both Classes**

1. **Edge Case Handling**
   - Index validation in `get()`, `remove()`, `insert()`.
   - Throw `IndexOutOfBoundsException` instead of returning `null` in some cases.

2. **Enhancements**
   - Add `reverse()` method for LL (reverse the links).
   - Add `clear()` to reset the list (LL and DLL).
   - Implement `Iterable<Node>` for Java iterator compatibility.
   - Use **generics** instead of hardcoded `int` for more flexibility.

3. **Performance**
   - In DLL `append()`, consider using `tail` instead of traversing with `last` for O(1).

---

# 🔥 Combined Example
```java
public class Main {
    public static void main(String[] args) {
        LL singly = new LL();
        singly.append(10);
        singly.addNode(5);
        singly.display(); // 5 -> 10 -> END

        DLL doubly = new DLL();
        doubly.insertfirst(1);
        doubly.append(2);
        doubly.insertAfter(3, 2);
        doubly.display(); // 1 -> 2 -> 3 -> END
        doubly.displayInReverse(); // 3 -> 2 -> 1 -> END
    }
}
```

---
