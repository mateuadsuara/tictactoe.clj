(ns tictactoe.game
  (:require [tictactoe.board :refer [place-mark finished? winner next-mark empty-board]]))

(defn do-turn [player board]
  (let [chosen-space (player board)]
    (place-mark chosen-space board)))

(defn- take-while+ [predicate collection]
  (lazy-seq
    (let [[current & rest] collection]
      (if (predicate current)
        (cons current (take-while+ predicate rest))
        [current]))))

(defn- game-state [board]
  {:board board
   :next-mark (next-mark board)
   :finished (finished? board)
   :winner (winner board)})

(defn game [player]
  (let [boards-in-each-turn (iterate #(do-turn player %) empty-board)]
    (map game-state (take-while+ #(not (finished? %)) boards-in-each-turn))))

(defn players [x o]
  (fn [board]
    (case (next-mark board)
      :x (x board)
      :o (o board))))
