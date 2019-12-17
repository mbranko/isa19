export class User {
  constructor(
    public id: number,  
    public username: string,
    public password: string,
    public firstName: string,
    public lastName: string,
    public email: string,
    public receiveNews: boolean) { }
}

export class Category {
  constructor(
    public id: number,
    public name: string,
    public parent: Category,
    public children: Category[],
    public products: Product[]) { }
}

export class Product {
  constructor(
    public id: number,
    public name: string,
    public price: number,
    public description: string,
    public category: Category) { }
}

export class ProductImage {
  constructor(
    public id: number,
    public height: number,
    public width: number,
    public contentType: string) { }
}

export class PurchaseOrder {
  constructor(
    public id?: number,
    public date?: Date,
    public user?: User,
    public items?: OrderItem[]) { }
}

export class OrderItem {
  constructor(
    public id?: number,
    public product?: Product,
    public order?: PurchaseOrder,
    public quantity?: number) { }
}

export class Supplier {
  constructor(
    public id: number,
    public name: string,
    public address: string) { }
}

export class CreditCard {
  constructor(
    public number?: string,
    public holderName?: string,
    public expiryMonth?: number,
    public expiryYear?: number,
    public cvc?: number) { }
}