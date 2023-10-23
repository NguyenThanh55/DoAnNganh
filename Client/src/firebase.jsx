// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
import { getFirestore } from "firebase/firestore";
import { getAuth } from "firebase/auth";


// const firebaseConfig = {
//   apiKey: "AIzaSyDtSfWKc3WYWeZ_65mYm8F9Y_qVjHKPOjo",
//   authDomain: "ouadmissions-eb77c.firebaseapp.com",
//   projectId: "ouadmissions-eb77c",
//   storageBucket: "ouadmissions-eb77c.appspot.com",
//   messagingSenderId: "262580743118",
//   appId: "1:262580743118:web:8bb223e95419b8121b599f",
//   measurementId: "G-61W2B1Z6H0"
// };

const firebaseConfiguration = {
  apiKey: "AIzaSyBZXodOub8ejDoTzNmb-s4J3dKMnsOgYTI",
  authDomain: "otp-ouadmissions.firebaseapp.com",
  projectId: "otp-ouadmissions",
  storageBucket: "otp-ouadmissions.appspot.com",
  messagingSenderId: "520791292090",
  appId: "1:520791292090:web:dc61e3d88a256363656a83",
  measurementId: "G-GMNSNG8PH9"
};

// Initialize Firebase
const app = initializeApp(firebaseConfiguration);
const analytics = getAnalytics(app);
const db = getFirestore(app);

const firebase = initializeApp(firebaseConfiguration, "firebase");
const auth = getAuth(firebase);
export { db, auth, app, firebase }




