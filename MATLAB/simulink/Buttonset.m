function varargout = Buttonset(varargin)
% BUTTONSET MATLAB code for Buttonset.fig
%      BUTTONSET, by itself, creates a new BUTTONSET or raises the existing
%      singleton*.
%
%      H = BUTTONSET returns the handle to a new BUTTONSET or the handle to
%      the existing singleton*.
%
%      BUTTONSET('CALLBACK',hObject,eventData,handles,...) calls the local
%      function named CALLBACK in BUTTONSET.M with the given input arguments.
%
%      BUTTONSET('Property','Value',...) creates a new BUTTONSET or raises the
%      existing singleton*.  Starting from the left, property value pairs are
%      applied to the GUI before Buttonset_OpeningFcn gets called.  An
%      unrecognized property name or invalid value makes property application
%      stop.  All inputs are passed to Buttonset_OpeningFcn via varargin.
%
%      *See GUI Options on GUIDE's Tools menu.  Choose "GUI allows only one
%      instance to run (singleton)".
%
% See also: GUIDE, GUIDATA, GUIHANDLES

% Edit the above text to modify the response to help Buttonset

% Last Modified by GUIDE v2.5 18-Jul-2016 09:35:17

% Begin initialization code - DO NOT EDIT
gui_Singleton = 1;
gui_State = struct('gui_Name',       mfilename, ...
                   'gui_Singleton',  gui_Singleton, ...
                   'gui_OpeningFcn', @Buttonset_OpeningFcn, ...
                   'gui_OutputFcn',  @Buttonset_OutputFcn, ...
                   'gui_LayoutFcn',  [] , ...
                   'gui_Callback',   []);
if nargin && ischar(varargin{1})
    gui_State.gui_Callback = str2func(varargin{1});
end

if nargout
    [varargout{1:nargout}] = gui_mainfcn(gui_State, varargin{:});
else
    gui_mainfcn(gui_State, varargin{:});
end
% End initialization code - DO NOT EDIT


% --- Executes just before Buttonset is made visible.
function Buttonset_OpeningFcn(hObject, eventdata, handles, varargin)
% This function has no output args, see OutputFcn.
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
% varargin   command line arguments to Buttonset (see VARARGIN)

% Choose default command line output for Buttonset
handles.output = hObject;

% Update handles structure
guidata(hObject, handles);

% UIWAIT makes Buttonset wait for user response (see UIRESUME)
% uiwait(handles.figure1);


% --- Outputs from this function are returned to the command line.
function varargout = Buttonset_OutputFcn(hObject, eventdata, handles) 
% varargout  cell array for returning output args (see VARARGOUT);
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Get default command line output from handles structure
varargout{1} = handles.output;


% --- Executes on button press in pushbutton1.
function pushbutton1_Callback(hObject, eventdata, handles)
% hObject    handle to pushbutton1 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
axes(handles.axes1);
imshow('E:\LUBO\Pictures\Saved Pictures\touxiang.jpg');
