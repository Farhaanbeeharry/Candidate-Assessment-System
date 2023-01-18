import { HttpHeaders } from "@angular/common/http";

export const environment = {
  production: true,
  apiUrl: 'http://candidate-assessment-server-develop-prj-elcamulab.apps.okd.svc.elca.ch/api',
  httpOptions: {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  }
};
