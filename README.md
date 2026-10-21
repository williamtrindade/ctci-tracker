# Cracking the Coding Interview - Tracker

Automated tests (JUnit 5) and Java stubs to practice the **189 questions** of
*Cracking the Coding Interview, 6th Edition*, by Gayle Laakmann McDowell — plus a one-page site to track your progress.

> ⚠️ **This repository does not contain the book's text.** The prompts and solutions are in the book; here you only
> get each question's reference, the expected signature and the tests. Buy the book:
> [Amazon.com](https://www.amazon.com/dp/0984782850) · [Amazon Brasil](https://www.amazon.com.br/dp/0984782850).

## How to use

1. **Fork** this repository and clone your fork.
2. Open the folder as a **Maven** project in your IDE (IntelliJ IDEA, VS Code or Eclipse). Requires **Java 21+**.
3. Read the question in the book and open the matching folder, e.g. `src/main/java/CTCI13URLify/`:
   - `readme.md` — the question's reference and the signature (or API) the tests expect;
   - `Solution.java` — the stub for you to implement (it throws `UnsupportedOperationException` until then).
4. Run the question's `SolutionTest` from your IDE (▶) or from the terminal:

   ```bash
   mvn test -Dtest=CTCI13URLify.SolutionTest   # one question
   mvn test -Dtest="CTCI2*Test"                # one chapter
   ```

5. Once the tests are green, commit to your fork and check off the question on the site.

## Progress site

The [`site/`](site) folder is a single static page (no build step): the book cover, what this repository is for, and a
grid with all 189 questions to check off as you solve them. Progress is saved only in your browser.

**Publish your own on GitHub Pages:**

1. In your fork, go to **Actions** and enable workflows (forks come with Actions disabled).
2. In **Settings → Pages → Build and deployment → Source**, select **GitHub Actions**.
3. Push to `main` (or run the *Deploy site* workflow manually).
4. The site will be at `https://<your-username>.github.io/cracking-the-coding-interview-tests/`, and the repository
   links automatically point to **your** fork.

To run it locally: `python3 -m http.server 8080` from the `site/` folder and open `http://localhost:8080/`.

## Structure

```
├── pom.xml                 Java 21, JUnit 5.11, H2 (SQL tests)
├── src/main/java/
│   ├── common/             ListNode, TreeNode
│   └── CTCI<ch><num><Name>/    readme.md + Solution.java (+ ready-made helper classes)
├── src/test/java/
│   ├── common/Db.java      in-memory H2 database (Ch. 14)
│   └── CTCI<ch><num><Name>/SolutionTest.java
├── cpp/                    Ch. 12 in C/C++ with the book's signatures (no tests)
└── site/                   progress site (GitHub Pages)
```

**Notes:**

- **Design (Chs. 7 and 9):** what you implement lives in nested classes inside `Solution.java`; the helper classes in
  the folder are already provided.
- **Chapter 12 (C/C++):** there is a testable Java version and, in `cpp/`, files with the original signatures to
  practice in C/C++ (`g++ -std=c++17 cpp/12_2_reverse_string.cpp -o out && ./out`).
- **Chapter 14 (SQL):** your method returns the query and the test runs it against an in-memory H2. If your IDE can't
  find H2, use *Reload All Maven Projects*.
- **`@Timeout`:** some DP questions intentionally fail with exponential brute force.

## Copyright

*Cracking the Coding Interview* © Gayle Laakmann McDowell / CareerCup. This is an independent, unofficial project
with no affiliation to the author or publisher. The tests, stubs, helper classes and site in this repository are
original work; question numbers and titles are used only for reference.
