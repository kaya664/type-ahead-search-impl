# type-ahead-search-impl
Type ahead search auto complete implementation with (Non-Binary Tree, Trie) Data Structures 

An auto complete be api

It reads files from a folder and uses collection of filenames as a dictionary. 
In the first iteration, Random meaningless filenames created via https://github.com/kaya664/random-meaningles-word-generator.
There are almost 80000 files in dictionary, Trie creation time is approx. 200ms. Traversal time for a single request is around 30-40ms.
One instance of application can handle 5000/s requests. If request count increases, connection problems exists.

Next iteration
    Handling more than 5000/s requests via load balancers.
    Handling bigger dictionary (1000000 filenames with different max length of texts)
