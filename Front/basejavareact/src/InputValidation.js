import * as yup from "yup";

export const GeneralInputValidation = yup
  .string()
  .matches(/(^[a-zA-Z0-9 ]*$)/, {
    message: "Caracter inválido",
    excludeEmptyString: true
  })
  .required("Campo requerido");

export const NameInputValidation = yup
  .string()
  .matches(/(^[a-zA-Z ]*$)/, {
    message: "Caracter inválido",
    excludeEmptyString: true
  })
  .required("Campo requerido");

export const NumericInputValidation = yup
  .number()
  .positive("El valor debe ser positivo")
  .required("Campo requerido");
