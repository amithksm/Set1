# Postgres1to1Transactional
1. One-One bi-directional relationship between User and UserProfile
2. @Transactional commit while registering a User
3. In case of non-transactional save if there is an error thrown, then both User and Profile table continues to be saved
   The actual expectation is that neither of the table should be saved to when an error occurs
4. In case of transactiona save if there is an error thrown, then the User.save() transaction is rolled back
