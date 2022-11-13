import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContentMaterialComponent } from './content-material.component';

describe('ContentMaterialComponent', () => {
  let component: ContentMaterialComponent;
  let fixture: ComponentFixture<ContentMaterialComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ContentMaterialComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ContentMaterialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
