import Axios from "axios-observable";
import swal from "sweetalert";

const BASE_URL = "http://localhost:8080/v1";
const PERSONS_API = BASE_URL.concat("/persons");

export const savePersonData = (
  firstName,
  lastName,
  mail,
  sex,
  birthDate,
  hobbies,
  callback
) => {
  const payload = {
    firstName: firstName,
    lastName: lastName,
    mail: mail,
    sex: sex,
    birthDate: birthDate,
    hobbies: hobbies
  };

  callback(true);
  Axios.post(PERSONS_API, payload).subscribe(
    response => {
      callback(false);
      swal("Operación completada", "Datos guardados", "success");
    },
    error => {
      callback(false);
      console.log(error);
    }
  );
};

export const Interceptors = {
  request: () => {
    Axios.interceptors.request.use(config => {
      console.log("Interceptor request", config);
      config.headers.Accept = "application/json";
      return config;
    });
  }
};
Interceptors.request();
