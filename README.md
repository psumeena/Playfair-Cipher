# Playfair-Cipher
   Playfair cipher is the first and best-known digraph substitution cipher, which uses the technique of symmetric encryption. 

## Playfair Cipher algorithm - Encryption:

The Playfair cipher encryption algorithm has two steps.

### Generating the Key Square matrix

- The ‘key square’ is a 5×5 grid consisting of alphabets that helps in encrypting the plain text.
- All these 25 letters should be unique.
- Since the grid can accommodate only 25 characters, there is no ‘J’ in this table. 'I' and 'J' are considered as a single letter.
- The key square will start with the key’s unique alphabet in the order of appearance, followed by the alphabet’s remaining characters in order.

### Encrypting the Plain Text

- Before encrypting the text, you need to divide the Playfair cipher plaintext into digraphs – pair of letter. 
- In the case of plaintext with an odd number of letters, add the letter ‘X’ to the last letter.
- If any pair contains same letters in the plain text, replace the second occurrence of the letter with ‘X’, e.g., ‘butter’ -> ‘butxer’.

**Rules for Playfair Cipher Encryption**

- Case I – **Both the letters in the digraph are in the same row** – Consider the letters to the right of each alphabet. Thus, if one of the digraph letters is the rightmost alphabet in the grid, consider the leftmost alphabet in the same row.
- Case II – **Both the letters in the digraph are in the same column** – Consider the letters below each alphabet. Thus, if one of the digraph letters is the grid’s bottommost letter, consider the topmost alphabet in the same column.
- Case III – **Neither Case I nor II is true** – Form a rectangle with the two letters in the digraph and consider the rectangle’s horizontal opposite corners.

## Playfair Cipher algorithm - Decryption:

- The decryption of the Playfair cipher follows the same process in reverse. The receiver has the same key and key table and can decrypt the message using the key.
