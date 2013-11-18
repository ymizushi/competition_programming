#!/usr/bin/env racket
#lang racket
(require test-engine/racket-tests)


(define map '())

(define (get-next target searched)
  (if (member target searched)
    null
    null
    )
  )

(define (search que searched count)
  (if (null? que)
    count
    (let* ([target (first que)]
           [next-list (get-next target searched)])
      (search (rest que) (append que next-list) (+ 1 count)))))

(check-expect (search (list (cons 2 2)) (list (cons 2 2)) 0) 22)
(test)
