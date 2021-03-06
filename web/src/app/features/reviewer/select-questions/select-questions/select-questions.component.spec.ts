import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SelectQuestionsComponent } from './select-questions.component';

describe('SelectQuestionsComponent', () => {
  let component: SelectQuestionsComponent;
  let fixture: ComponentFixture<SelectQuestionsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SelectQuestionsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SelectQuestionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
