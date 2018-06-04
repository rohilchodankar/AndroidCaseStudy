# AndroidCaseStudy

- This app was targeted at API level 19. What exciting options become available by updating it to target API level 24?
  Ans. MultiWindow Support Configuration will be available if we target API 24 Nougat
- This app is focused at phones primarily, but is a prime candidate for a flexible design that would intelligently expand for tablets.
  Ans. Can Handle it for tablet using dimen.xml for that particular screen size and adjusting the values.
- The initial screen is a list view. How would you implement a toggle for grid view and what would that grid view look like?
  Ans.Have implemented a basic verison of it, Although need some improvement in the Code
- Ignore these suggestions and find your own inspiration.
  Ans. 1. Have persisted the user Deal Dislay style (List or Grid) so that the user is shown the same
       2. Also Added Shared element Transition from the List to Details screen from above Lollipop users
       3. Implemented MVVM architecture with Dagger 2.0, Retrofit, Rx Java, Architecture Components
