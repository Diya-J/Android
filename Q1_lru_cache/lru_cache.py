class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.prev = None
        self.next = None

class LRUCache:
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.cache = {}  # Map key to node
        # Dummy head and tail nodes
        self.head = Node(0, 0)
        self.tail = Node(0, 0)
        # Initialize the doubly linked list
        self.head.next = self.tail
        self.tail.prev = self.head

    def _remove(self, node):
        """Remove node from the linked list."""
        prev = node.prev
        nxt = node.next
        prev.next = nxt
        nxt.prev = prev

    def _add(self, node):
        """Add node right after head."""
        node.prev = self.head
        node.next = self.head.next
        self.head.next.prev = node
        self.head.next = node

    def get(self, key: int) -> int:
        if key in self.cache:
            node = self.cache[key]
            # Move the accessed node to the front (most recently used)
            self._remove(node)
            self._add(node)
            return node.value
        return -1  # Key not found

    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            # Update the value and move to front
            self._remove(self.cache[key])
        elif len(self.cache) >= self.capacity:
            # Remove the least recently used item
            lru = self.tail.prev
            self._remove(lru)
            del self.cache[lru.key]
        # Add new node to the front
        new_node = Node(key, value)
        self._add(new_node)
        self.cache[key] = new_node
