import {User} from "./user.interface";

export interface Response {
    data: {
      users: User[];
    };
}
