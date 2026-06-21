# QKart Automation — Selenium + TestNG UI Test Suite

> A Selenium WebDriver automation project built to test core e-commerce workflows on the **QKart** shopping platform. This project was developed as part of a structured QA learning path and demonstrates real-world UI automation skills using Java, TestNG, and the Page Object Model.

---

## What This Project Demonstrates

| Skill | Details |
|---|---|
| **UI Automation** | End-to-end browser automation using Selenium WebDriver |
| **Reusable Framework Design** | Page Object Model separates test logic from UI interactions |
| **Locator Strategy** | Mix of XPath, CSS selectors, and link text locators |
| **Test Data Handling** | TestNG `@Parameters` and `testng.xml` for parameterized test data |
| **Regression Testing** | Tests organized into `Sanity_test` and `Regression_Test` groups |
| **Assertion Patterns** | Both hard asserts (`Assert`) and soft asserts (`SoftAssert`) used |

---

## Tech Stack

| Tool / Library | Version / Role |
|---|---|
| **Java** | Primary language |
| **Selenium WebDriver** | 4.0.0-alpha-1 — browser automation |
| **TestNG** | 7.6.0 — test runner and reporting |
| **WebDriverManager** | 4.4.3 — automatic ChromeDriver management |
| **Gradle** | Build tool and test runner |
| **Zalenium / Remote WebDriver** | Remote execution via localhost hub |

---

## Test Scenarios Automated

| Test Case | Description | Group |
|---|---|---|
| **TC01** | Verify new user registration flow — register, login, logout | Sanity |
| **TC02** | Verify duplicate registration is rejected | Sanity |
| **TC03** | Verify product search — valid results and no-result message | Sanity |
| **TC04** | Verify size chart presence, dropdown, and content validation | Regression |
| **TC05** | Add multiple products to cart and complete checkout | Sanity |
| **TC06** | Edit cart — change product quantities, remove items, checkout | Regression |
| **TC07** | Verify insufficient wallet balance error on checkout | Sanity |
| **TC08** | Verify cart data persists when navigating to a new browser tab | Regression |
| **TC09** | Verify Privacy Policy and Terms of Service links open in new tabs | Regression |
| **TC10** | Verify Contact Us modal submits and closes correctly | Regression |
| **TC11** | Verify advertisement iframes are present and clickable post-order | Sanity |

---

## Framework Structure

```
Qkart-Project/
├── app/
│   └── src/
│       └── test/
│           └── java/
│               └── QKART_TESTNG/
│                   ├── QKART_Tests.java       # Main test class (TC01–TC11)
│                   ├── ListenerClass.java     # TestNG listener (hook for events)
│                   ├── testng.xml             # Suite configuration & test groups
│                   └── pages/
│                       ├── Register.java      # Page Object: Registration page
│                       ├── Login.java         # Page Object: Login page
│                       ├── Home.java          # Page Object: Home/search/cart page
│                       ├── SearchResult.java  # Page Object: Product card & size chart
│                       └── Checkout.java      # Page Object: Checkout & address page
├── app/build.gradle                           # Gradle config & dependencies
├── settings.gradle
├── gradlew / gradlew.bat                      # Gradle wrapper
├── selenium-run.sh                            # Selenium setup script
└── test-results.xml                           # TestNG result snapshot
```

---

## Key Automation Concepts Used

- **Page Object Model (POM)** — Each page (Register, Login, Home, etc.) has its own class encapsulating locators and actions
- **Explicit Waits** — `WebDriverWait` with `ExpectedConditions` used for dynamic element loading
- **Soft Assertions** — `SoftAssert` used in TC03 and TC04 to continue test execution after non-critical failures
- **TestNG Annotations** — `@BeforeSuite`, `@AfterSuite`, `@Test`, `@Parameters` used for test lifecycle management
- **TestNG Groups** — Tests split into `Sanity_test` and `Regression_Test` to allow selective execution
- **Multi-tab / Window Handling** — `driver.getWindowHandles()` used in TC08, TC09, TC11
- **iframe Interaction** — `driver.switchTo().frame()` for advertisement iframe tests in TC11
- **Remote WebDriver** — Tests configured to run against a Zalenium hub at `localhost:8082`

---

## How to Run Tests

### Prerequisites

- Java 8+
- Gradle (or use the provided `./gradlew` wrapper)
- A Selenium Grid or Zalenium instance running at `http://localhost:8082/wd/hub`

### Run All Tests

```bash
./gradlew test
```

### Run a Specific Group

Open `testng.xml` and set the desired group (`Sanity_test` or `Regression_Test`) in the `<groups>` section, then run:

```bash
./gradlew test
```

---

## Reporting

TestNG generates a default HTML report after each test run.

- **Location:** `build/reports/tests/test/index.html`
- **Format:** TestNG default listener output (enabled via `useDefaultListeners = true` in `build.gradle`)
- A snapshot of test results is also committed as `test-results.xml` in the root directory

---

## Future Improvements

- [ ] Integrate **ExtentReports** for richer HTML reporting with screenshots
- [ ] Add **CI/CD pipeline** (GitHub Actions) for automated test runs on pull requests
- [ ] Replace hardcoded test data with external Excel/JSON data providers
- [ ] Upgrade to latest stable Selenium 4 version
- [ ] Add parallel test execution configuration in `testng.xml`
- [ ] Add screenshot capture on test failure

---

## GitHub Topics

`selenium` `java` `testng` `qa-automation` `automation-testing` `pom` `webdriver` `page-object-model` `gradle`
