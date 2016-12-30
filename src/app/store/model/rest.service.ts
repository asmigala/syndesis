import { Restangular } from 'ng2-restangular';
import { Observable } from 'rxjs/Observable';

import { BaseResource } from './baseresource.model';

export abstract class RESTService<T extends BaseResource, L extends Array<T>> {

  private restangularService: Restangular;

  protected constructor(restangular: Restangular) {
    this.restangularService = restangular;
  }

  get(id: string): Observable<T> {
    return this.restangularService.one(id).get();
  }

  list(): Observable<L> {
    return this.restangularService.getList();
  }

  create(obj: T): Observable<T> {
    return this.restangularService.post(obj);
  }

  update(obj: T): Observable<T> {
    return this.restangularService.one(obj.id).put(obj);
  }

  delete(obj: T) {
    return this.restangularService.one(obj.id).delete();
  }

}
