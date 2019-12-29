import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteSearchComponent } from './delete-search.component';

describe('DeleteSearchComponent', () => {
  let component: DeleteSearchComponent;
  let fixture: ComponentFixture<DeleteSearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeleteSearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
