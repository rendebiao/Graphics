# Graphics state相关的color、drawable

State
    
    控件单一状态

States
    
    控件完整状态

ColorStateListBuilder
    
    代码创建ColorStateList
    ColorStateList colorStateList = new ColorStateListBuilder().addItem(Color.RED, State.STATE_CHECKED).addItem(Color.BLUE, State.STATE_PRESSED).build();

SimpleColorStateList
    
    创建单一或较少状态的ColorStateList
    SimpleColorStateList simpleColorStateList1 = new SimpleColorStateList(Color.RED);
    SimpleColorStateList simpleColorStateList2 = new SimpleColorStateList(Color.RED, Color.GRAY);
    SimpleColorStateList simpleColorStateList3 = new SimpleColorStateList(State.checked.getAttr(), Color.RED, Color.GRAY, Color.GREEN);

StateListDrawableBuilder
    
    代码创建StateListDrawable
    StateListDrawable stateListDrawable = new StateListDrawableBuilder().addItem(drawable1,State.checked.getAttr()).addItem(drawable2, State.pressed.getAttr()).build();

Drawable
    
    各种几何图形Drawable
    BitmapCornerDrawable
    BitmapOvalDrawable
    BitmapPolygonDrawable
    ColorCornerDrawable
    ColorOvalDrawable
    ColorPolygonDrawable

ShapeUtils
    
    快速创建GradientDrawable

[![](https://www.jitpack.io/v/rendebiao/Graphics.svg)](https://www.jitpack.io/#rendebiao/Graphics)
