# university-coursework

A collection of core academic projects, application source code, low-level system utilities, algorithms \& data structures from my computer science studies



\# Computer Science Portfolio



This repository consolidates core units projects and system utilities developed during my computer science journey across Monash University and UNPAR. 



\---



\## Project Index 



\### 1. Constraint-Satisfaction Sudoku Engine (Solver \& Generator)

\* \*\*Directory:\*\* `/sudoku-solver-generator`

\* \*\*Core Tech:\*\* Python, Backtracking, Heuristic Constraint Propagation

\* \*\*Key Features:\*\* Engineered a complete recursive matrix puzzle-engine handling $4\\times4$, $9\\times9$, and $16\\times16$ multidimensional arrays. 

&#x20; \* \*\*Heuristic Optimization:\*\* Implemented the Minimum Remaining Values (MRV) heuristic to prioritize dynamic cell selection, substantially pruning tree traversal depth.

&#x20; \* \*\*Constraint Propagation:\*\* Integrated a deductive inference loop mechanism (`value\_by\_single`) that resolves forward and backward singles deterministically before falling back to recursive branching.

&#x20; \* \*\*Unique Board Generator:\*\* Synthesized a random cell-omission pipeline that continuously runs dual-solution validations (`solvegenerate`) to programmatically output structurally guaranteed, unique boards.



\### 2. Native Android Movie Library App

\* \*\*Directory:\*\* `/android-movie-library`

\* \*\*Core Tech:\*\* Java, Android SDK, Firebase Realtime Database, MVVM Architecture

\* \*\*Key Features:\*\* Implemented local persistence alongside live cloud database synchronization. Engineered an asynchronous system event gateway (`BroadcastReceiver`) to intercept and parse text-payload inputs, and overrode the hardware touch layer to process custom velocity gesture triggers.



\### 3. Enterprise Excel Data Parser

\* \*\*Directory:\*\* `/statistical-parser`

\* \*\*Core Tech:\*\* Java, Apache POI Library

\* \*\*Key Features:\*\* Built a standalone compiler utility to stream, parse, and analyze numerical cell column structures from spreadsheet files. Manually injected linear interpolation algorithms to compute data quartiles and find out ($IQR$/Outliers) without external math packages.



\### 4. Web Penetration Testing \& Vulnerability Audit

\* \*\*Directory:\*\* `/web-security-audit`

\* \*\*Core Tech:\*\* Network Security Analytics

\* \*\*Key Features:\*\* Conducted an end-to-end security audit on a target web application layout. Documented cross-site scripting (XSS), SQL injection, and authentication flaws into an enterprise-grade vulnerability report.



\### 5. Low-Level Architecture Logic

\* \*\*Directory:\*\* `/low-level-architecture`

\* \*\*Core Tech:\*\* MARIE Assembly

\* \*\*Key Features:\*\* Programmed raw machine-level instructions focusing on strict hardware optimization. Solved complex computational problems using direct register allocation, programmatic memory addressing boundaries, and manual control-flow branch execution loops.



