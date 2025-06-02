class MyHashMap:
    def __init__(self):
        self.size = 1000
        self.buckets = [[] for _ in range(self.size)]

    def _hash(self, key):
        """Hash function to compute index for a key."""
        return key % self.size

    def put(self, key: int, value: int) -> None:
        index = self._hash(key)
        # Check if the key exists and update
        for i, (k, v) in enumerate(self.buckets[index]):
            if k == key:
                self.buckets[index][i] = (key, value)
                return
        # If key does not exist, append new key-value pair
        self.buckets[index].append((key, value))

    def get(self, key: int) -> int:
        index = self._hash(key)
        for k, v in self.buckets[index]:
            if k == key:
                return v
        return -1  # Key not found

    def remove(self, key: int) -> None:
        index = self._hash(key)
        for i, (k, v) in enumerate(self.buckets[index]):
            if k == key:
                del self.buckets[index][i]
                return
