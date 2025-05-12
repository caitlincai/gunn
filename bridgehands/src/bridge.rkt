#lang racket

;project by Caitlin Cai

;extension : hand-error - checking for a valid hand of 13 cards!

;Card-val : assigning values to each face card
(define (card-val card)
  (cond ((equal? (bf card) 'a) 4)
        ((equal? (bf card) 'k) 3)
        ((equal? (bf card) 'q) 2)
        ((equal? (bf card) 'j) 1)
        (0)))

;High-card-points : returns total number of points from high cards in the hand
(define (high-card-points hand)
  (accumulate + (every card-val hand)))

;Count-suit : number of cards with given suit
(define (count-suit suit hand)
  (count (keep (lambda (x)
    (member? suit x))hand)))

;Suit-counts : number of suits in each hand (spades, hearts, club, and diamonds respectively)
(define (suit-counts hand)
  (se
   (count-suit 's hand)
   (count-suit 'h hand)
   (count-suit 'c hand)
   (count-suit 'd hand)))

;suit-dist-points : returns the number of distribution points your hand gets for having that number of cards in a particular suit
(define (suit-dist-points num)
  (cond ((= num 2) 1)
        (( = num 1) 2)
        ((= num 0) 3)
        (else 0)))

;hand-dist-points : takes a hand as its argument and returns the number of distribution points the hand is worth
(define (hand-dist-points hand)
  (accumulate + (every suit-dist-points (suit-counts hand))))

;bridge val: takes a hand as its argument and returns the total number of points that the hand is worth.
(define (bridge-val hand)
  (+ (hand-dist-points hand)(high-card-points hand)))

'(* ending results! *)
(bridge-val '(sa s10 s7 s6 s2 hq hj h9 ck c4 dk d9 d3))
(bridge-val '(h3 d7 sk s3 c10 dq d8 s9 s4 d10 c7 d4 s2))

(newline)
;hand-error : check for 13 cards
'(** hand-error **)
(define (hand-error hand)
  (if (not (equal? (count hand) 13))
        '(ERROR! a valid hand must have 13 cards!)
        hand))

(hand-error '(ha ha ha ha))