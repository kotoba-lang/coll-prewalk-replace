(ns kotoba.coll.prewalk-replace
  "prewalk-replace -- one definition, addressed on its own.

  Split out of kotoba.lang.text on 2026-09-09. The unit here is the
  DEFINITION, not the library: this repo holds prewalk-replace and names, in its
  deps.edn, exactly the definitions prewalk-replace reaches. Nothing else."
  (:require [kotoba.coll.prewalk :refer [prewalk]]))

(defn prewalk-replace
  "Recursively transform `form` by replacing every node that is a key in
  `replacements` with that key's value, top-down. Mirrors
  clojure.walk/prewalk-replace."
  [replacements form]
  (prewalk (fn [x] (if (contains? replacements x) (get replacements x) x)) form))
