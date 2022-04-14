# Swifty_Companion
Project of Android dev Branch at 42Rome

[![cromalde's 42 swifty-companion Score](https://badge42.vercel.app/api/v2/cl1z1axw3001109mox1m22pjp/project/2395595)](https://github.com/JaeSeoKim/badge42)


[SubjectPdf](https://cdn.intra.42.fr/pdf/pdf/23559/en.subject.pdf)

In this project we have to:

Create a student search app for the school.

There are 2 activities :
the main one simply acts as a home page with a field where to insert the UserName to search;

the other displays with different fragments the various information, of the student

The data is requested from the school server via API, previously it must be created a token that is inserted in the header of the request.

It was required not to create a new token for each request so before calling the api I check that the token saved in the cache is valid, so I recreate it automatically ONLY if it had expired.

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

<img width="100" alt="Schermata 2021-11-10 alle 18 24 17" src="https://user-images.githubusercontent.com/74542458/141163673-5993ef70-15bc-4325-bc69-961f4956d460.png">  <img width="100" alt="Schermata 2021-11-10 alle 18 24 33" src="https://user-images.githubusercontent.com/74542458/141163690-94910448-c175-4961-bda3-1519af822a98.png">  <img width="100" alt="Schermata 2021-11-10 alle 18 24 43" src="https://user-images.githubusercontent.com/74542458/141163703-31fbbd1e-231e-4ca5-a379-05c4c139b6eb.png">  <img width="100" alt="Schermata 2021-11-10 alle 18 24 58" src="https://user-images.githubusercontent.com/74542458/141163555-62293a05-41b2-491e-b8e0-2538a081fb40.png">  <img width="100" alt="Schermata 2021-11-10 alle 18 25 04" src="https://user-images.githubusercontent.com/74542458/141163709-1c1e753f-7518-47c1-b6ac-8673c0ced91b.png">
